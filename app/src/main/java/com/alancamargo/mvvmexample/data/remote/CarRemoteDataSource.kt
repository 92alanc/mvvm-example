package com.alancamargo.mvvmexample.data.remote

import com.alancamargo.mvvmexample.domain.model.Car

internal interface CarRemoteDataSource {

    suspend fun getCars(): List<Car>
}
