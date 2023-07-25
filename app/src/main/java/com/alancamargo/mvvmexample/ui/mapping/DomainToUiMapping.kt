package com.alancamargo.mvvmexample.ui.mapping

import com.alancamargo.mvvmexample.domain.model.Car
import com.alancamargo.mvvmexample.ui.model.UiCar

internal fun Car.toUi() = UiCar(
    id = id,
    name = name,
    make = make,
    year = year.toString()
)
