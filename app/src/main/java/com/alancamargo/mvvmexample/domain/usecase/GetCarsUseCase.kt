package com.alancamargo.mvvmexample.domain.usecase

import com.alancamargo.mvvmexample.domain.model.CarListResult
import kotlinx.coroutines.flow.Flow

internal interface GetCarsUseCase {

    operator fun invoke(): Flow<CarListResult>
}
