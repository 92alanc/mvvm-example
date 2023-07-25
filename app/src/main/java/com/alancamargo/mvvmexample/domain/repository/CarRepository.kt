package com.alancamargo.mvvmexample.domain.repository

import com.alancamargo.mvvmexample.domain.model.CarListResult

internal interface CarRepository {

    suspend fun getCars(): CarListResult
}
