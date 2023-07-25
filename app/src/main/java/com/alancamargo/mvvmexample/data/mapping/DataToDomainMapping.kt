package com.alancamargo.mvvmexample.data.mapping

import com.alancamargo.mvvmexample.data.model.CarResponse
import com.alancamargo.mvvmexample.data.model.DbCar
import com.alancamargo.mvvmexample.domain.model.Car

internal fun CarResponse.toDomain() = Car(
    id = id,
    name = name.orEmpty(),
    make = make.orEmpty(),
    year = year ?: 1900
)

internal fun DbCar.toDomain() = Car(
    id = id,
    name = name,
    make = make,
    year = year
)
