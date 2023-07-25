package com.alancamargo.mvvmexample.domain.usecase

import com.alancamargo.mvvmexample.domain.model.CarListResult
import com.alancamargo.mvvmexample.domain.repository.CarRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withTimeout
import javax.inject.Inject

private const val TIMEOUT_DELAY_MILLIS = 10000L
private const val RIDICULOUSLY_LONG_TIME_MILLIS = 20000L

internal class GetCarsUseCaseImpl @Inject constructor(
    private val repository: CarRepository
) : GetCarsUseCase {

    override fun invoke(): Flow<CarListResult> = flow {
        withTimeout(TIMEOUT_DELAY_MILLIS) {
            emitSuccess()
        }
    }

    private suspend fun FlowCollector<CarListResult>.emitSuccess() {
        val result = repository.getCars()
        emit(result)
    }

    private suspend fun FlowCollector<CarListResult>.emitTimeoutError() {
        delay(RIDICULOUSLY_LONG_TIME_MILLIS)
    }

    private fun throwRandomException() {
        throw IllegalStateException()
    }

    private suspend fun FlowCollector<CarListResult>.emitNetworkError() {
        emit(CarListResult.NetworkError)
    }

    private suspend fun FlowCollector<CarListResult>.emitGenericError() {
        emit(CarListResult.GenericError)
    }
}
