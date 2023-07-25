package com.alancamargo.mvvmexample.data.mapping

import com.alancamargo.mvvmexample.data.model.DbCar
import com.alancamargo.mvvmexample.domain.model.Car

internal fun Car.toDb() = DbCar(
    id = id,
    name = name,
    make = make,
    year = year
)
