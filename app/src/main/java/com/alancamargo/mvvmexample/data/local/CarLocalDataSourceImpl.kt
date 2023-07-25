package com.alancamargo.mvvmexample.data.local

import com.alancamargo.mvvmexample.data.db.CarDb
import com.alancamargo.mvvmexample.data.mapping.toDb
import com.alancamargo.mvvmexample.data.mapping.toDomain
import com.alancamargo.mvvmexample.domain.model.Car
import javax.inject.Inject

internal class CarLocalDataSourceImpl @Inject constructor(
    private val database: CarDb
) : CarLocalDataSource {

    override suspend fun getCars(): List<Car> {
        return database.getCars()?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun upsertCar(car: Car) {
        val dbCar = car.toDb()
        database.upsertCar(dbCar)
    }
}
