package com.alancamargo.mvvmexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alancamargo.mvvmexample.di.IoDispatcher
import com.alancamargo.mvvmexample.domain.model.CarListResult
import com.alancamargo.mvvmexample.domain.usecase.GetCarsUseCase
import com.alancamargo.mvvmexample.ui.mapping.toUi
import com.alancamargo.mvvmexample.ui.model.UiCar
import com.alancamargo.mvvmexample.ui.model.UiErrorType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CarListViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow(CarListViewState())
    private val _action = MutableSharedFlow<CarListViewAction>()

    val state: StateFlow<CarListViewState> = _state
    val action: SharedFlow<CarListViewAction> = _action

    fun getCars() {
        viewModelScope.launch(dispatcher) {
            getCarsUseCase().onStart {
                _state.update { it.onLoading() }
            }.onCompletion {
                _state.update { it.onFinishedLoading() }
            }.catch { error ->
                val errorType = when (error) {
                    is TimeoutCancellationException -> UiErrorType.NETWORK
                    else -> UiErrorType.GENERIC
                }

                _state.update { it.onError(errorType) }
            }.collect(::handleCarListResult)
        }
    }

    fun onCarItemClicked(car: UiCar) {
        val action = CarListViewAction.NavigateToCarDetails(car)
        sendAction(action)
    }

    fun onExitClicked() {
        sendAction(CarListViewAction.Finish)
    }

    private fun handleCarListResult(result: CarListResult) = when (result) {
        is CarListResult.Success -> _state.update {
            val uiCars = result.cars.map { car ->
                car.toUi()
            }
            it.onCarsReceived(uiCars)
        }

        is CarListResult.NetworkError -> _state.update { it.onError(UiErrorType.NETWORK) }
        is CarListResult.GenericError -> _state.update { it.onError(UiErrorType.GENERIC) }
    }

    private fun sendAction(action: CarListViewAction) {
        viewModelScope.launch(dispatcher) {
            _action.emit(action)
        }
    }
}
