package com.alancamargo.mvvmexample.ui.navigation

import android.content.Context
import android.widget.Toast
import com.alancamargo.mvvmexample.navigation.CarDetailsActivityNavigation
import com.alancamargo.mvvmexample.ui.model.UiCar
import javax.inject.Inject

internal class CarDetailsActivityNavigationImpl @Inject constructor(
) : CarDetailsActivityNavigation {

    override fun startActivity(context: Context, car: UiCar) {
        Toast.makeText(context, car.name, Toast.LENGTH_SHORT).show()
    }
}
