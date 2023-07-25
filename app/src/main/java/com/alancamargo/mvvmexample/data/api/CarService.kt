package com.alancamargo.mvvmexample.data.api

import com.alancamargo.mvvmexample.data.model.CarResponse

internal interface CarService {

    suspend fun getCars(): List<CarResponse>
}
