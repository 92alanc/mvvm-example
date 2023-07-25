package com.alancamargo.mvvmexample.data.db

import com.alancamargo.mvvmexample.data.model.DbCar
import kotlinx.coroutines.delay
import java.util.UUID
import javax.inject.Inject

internal class MockCarDb @Inject constructor() : CarDb {

    override suspend fun getCars(): List<DbCar> {
        delay(timeMillis = 1000)
        return listOf(
            DbCar(
                id = UUID.randomUUID().toString(),
                name = "Golzão quadrado",
                make = "Volkswagen",
                year = 1980
            ),
            DbCar(
                id = UUID.randomUUID().toString(),
                name = "Uno com escada",
                make = "FIAT",
                year = 1993
            ),
            DbCar(
                id = UUID.randomUUID().toString(),
                name = "Escort rebaixado",
                make = "Ford",
                year = 1996
            ),
            DbCar(
                id = UUID.randomUUID().toString(),
                name = "Kadett tubarão",
                make = "Chevrolet",
                year = 1994
            )
        )
    }

    override suspend fun upsertCar(car: DbCar) {
        delay(timeMillis = 200)
    }
}
