package com.alancamargo.mvvmexample.di

import com.alancamargo.mvvmexample.data.local.CarLocalDataSource
import com.alancamargo.mvvmexample.data.local.CarLocalDataSourceImpl
import com.alancamargo.mvvmexample.data.remote.CarRemoteDataSource
import com.alancamargo.mvvmexample.data.remote.CarRemoteDataSourceImpl
import com.alancamargo.mvvmexample.data.repository.CarRepositoryImpl
import com.alancamargo.mvvmexample.domain.repository.CarRepository
import com.alancamargo.mvvmexample.domain.usecase.GetCarsUseCase
import com.alancamargo.mvvmexample.domain.usecase.GetCarsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class CarModule {

    @Binds
    @ViewModelScoped
    abstract fun bindCarRemoteDataSource(impl: CarRemoteDataSourceImpl): CarRemoteDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindCarLocalDataSource(impl: CarLocalDataSourceImpl): CarLocalDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindCarRepository(impl: CarRepositoryImpl): CarRepository

    @Binds
    @ViewModelScoped
    abstract fun bindGetCarsUseCase(impl: GetCarsUseCaseImpl): GetCarsUseCase
}
