package com.alancamargo.mvvmexample.data.remote

import com.alancamargo.mvvmexample.data.api.CarService
import com.alancamargo.mvvmexample.data.mapping.toDomain
import com.alancamargo.mvvmexample.domain.model.Car
import javax.inject.Inject

internal class CarRemoteDataSourceImpl @Inject constructor(
    private val service: CarService
) : CarRemoteDataSource {

    override suspend fun getCars(): List<Car> {
        return service.getCars().map { it.toDomain() }
    }
}
