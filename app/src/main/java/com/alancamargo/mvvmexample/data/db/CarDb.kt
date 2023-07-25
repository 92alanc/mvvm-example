package com.alancamargo.mvvmexample.data.db

import com.alancamargo.mvvmexample.data.model.DbCar

internal interface CarDb {

    suspend fun getCars(): List<DbCar>?

    suspend fun upsertCar(car: DbCar)
}
