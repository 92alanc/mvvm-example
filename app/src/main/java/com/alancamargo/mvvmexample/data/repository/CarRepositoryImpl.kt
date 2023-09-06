package com.alancamargo.mvvmexample.data.repository

import com.alancamargo.mvvmexample.data.local.CarLocalDataSource
import com.alancamargo.mvvmexample.data.remote.CarRemoteDataSource
import com.alancamargo.mvvmexample.domain.model.CarListResult
import com.alancamargo.mvvmexample.domain.repository.CarRepository
import java.io.IOException
import javax.inject.Inject

internal class CarRepositoryImpl @Inject constructor(
    private val remoteDataSource: CarRemoteDataSource,
    private val localDataSource: CarLocalDataSource
) : CarRepository {

    override suspend fun getCars(): CarListResult {
        val result = runCatching {
            val cars = remoteDataSource.getCars().onEach {
                localDataSource.upsertCar(it)
            }

            CarListResult.Success(cars)
        }.getOrElse { remoteError ->
            runCatching {
                val cars = localDataSource.getCars()
                CarListResult.Success(cars)
            }.getOrElse {
                when (remoteError.cause) {
                    is IOException -> CarListResult.NetworkError
                    else -> CarListResult.GenericError
                }
            }
        }

        return result
    }
}
