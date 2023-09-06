package com.alancamargo.mvvmexample.di

import com.alancamargo.mvvmexample.data.api.CarService
import com.alancamargo.mvvmexample.data.db.CarDb
import com.alancamargo.mvvmexample.navigation.CarDetailsActivityNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.mockk.mockk
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [
        CarNavigationModule::class,
        DataModule::class
    ]
)
internal object TestModule {

    @Provides
    @Singleton
    fun provideMockCarDetailsActivityNavigation(): CarDetailsActivityNavigation {
        return mockk(relaxed = true)
    }

    @Provides
    @Singleton
    fun provideMockCarService(): CarService = mockk()

    @Provides
    @Singleton
    fun provideMockCarDb(): CarDb = mockk(relaxed = true)
}
