package com.alancamargo.mvvmexample.data.api

import com.alancamargo.mvvmexample.data.model.CarResponse
import kotlinx.coroutines.delay
import java.util.UUID
import javax.inject.Inject

internal class MockCarService @Inject constructor() : CarService {

    override suspend fun getCars(): List<CarResponse> {
        delay(timeMillis = 3000)
        return listOf(
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
    }
}
