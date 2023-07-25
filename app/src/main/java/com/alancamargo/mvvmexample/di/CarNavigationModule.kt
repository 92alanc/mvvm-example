package com.alancamargo.mvvmexample.di

import com.alancamargo.mvvmexample.navigation.CarDetailsActivityNavigation
import com.alancamargo.mvvmexample.ui.navigation.CarDetailsActivityNavigationImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
internal abstract class CarNavigationModule {

    @Binds
    @ActivityScoped
    abstract fun bindCarDetailsActivityNavigation(
        impl: CarDetailsActivityNavigationImpl
    ): CarDetailsActivityNavigation
}
