package com.alancamargo.mvvmexample.tools

import com.alancamargo.mvvmexample.data.model.CarResponse
import java.util.UUID

internal fun stubCarResponseList() = listOf(
    CarResponse(
        id = UUID.randomUUID().toString(),
        name = "Golzão quadrado",
        make = "Volkswagen",
        year = 1980
    ),
    CarResponse(
        id = UUID.randomUUID().toString(),
        name = "Uno com escada",
        make = "FIAT",
        year = 1993
    ),
    CarResponse(
        id = UUID.randomUUID().toString(),
        name = "Escort rebaixado",
        make = "Ford",
        year = 1996
    ),
    CarResponse(
        id = UUID.randomUUID().toString(),
        name = "Kadett tubarão",
        make = "Chevrolet",
        year = 1994
    )
)
