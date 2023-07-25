package com.alancamargo.mvvmexample.domain.model

internal sealed class CarListResult {

    data class Success(val cars: List<Car>) : CarListResult()

    object NetworkError : CarListResult()

    object GenericError : CarListResult()
}
