package com.alancamargo.mvvmexample.ui.viewmodel

import com.alancamargo.mvvmexample.ui.model.UiCar

internal sealed class CarListViewAction {

    data class NavigateToCarDetails(val car: UiCar) : CarListViewAction()

    object Finish : CarListViewAction()
}
