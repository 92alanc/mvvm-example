package com.alancamargo.mvvmexample.navigation

import android.content.Context
import com.alancamargo.mvvmexample.ui.model.UiCar

interface CarDetailsActivityNavigation {

    fun startActivity(context: Context, car: UiCar)
}
