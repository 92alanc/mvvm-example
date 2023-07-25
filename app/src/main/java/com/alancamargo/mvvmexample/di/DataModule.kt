package com.alancamargo.mvvmexample.di

import com.alancamargo.mvvmexample.data.api.CarService
import com.alancamargo.mvvmexample.data.api.MockCarService
import com.alancamargo.mvvmexample.data.db.CarDb
import com.alancamargo.mvvmexample.data.db.MockCarDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

    @Provides
    @Singleton
    fun provideCarService(): CarService = MockCarService()

    @Provides
    @Singleton
    fun provideCarDb(): CarDb = MockCarDb()
}
