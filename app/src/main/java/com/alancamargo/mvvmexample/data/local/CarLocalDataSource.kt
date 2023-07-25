package com.alancamargo.mvvmexample.data.local

import com.alancamargo.mvvmexample.domain.model.Car

internal interface CarLocalDataSource {

    suspend fun getCars(): List<Car>

    suspend fun upsertCar(car: Car)
}
