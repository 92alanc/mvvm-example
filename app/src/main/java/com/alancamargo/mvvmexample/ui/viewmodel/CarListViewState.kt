package com.alancamargo.mvvmexample.ui.viewmodel

import com.alancamargo.mvvmexample.ui.model.UiCar
import com.alancamargo.mvvmexample.ui.model.UiErrorType

internal data class CarListViewState(
    val isLoading: Boolean = false,
    val cars: List<UiCar>? = null,
    val errorType: UiErrorType? = null
) {

    fun onLoading() = copy(
        isLoading = true,
        cars = null,
        errorType = null
    )

    fun onFinishedLoading() = copy(isLoading = false)

    fun onCarsReceived(cars: List<UiCar>) = copy(
        cars = cars,
        errorType = null
    )

    fun onError(errorType: UiErrorType) = copy(
        errorType = errorType,
        cars = null
    )
}
