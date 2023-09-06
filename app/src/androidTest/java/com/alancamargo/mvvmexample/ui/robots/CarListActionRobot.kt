package com.alancamargo.mvvmexample.ui.robots

import com.alancamargo.mvvmexample.tools.performClick
import com.alancamargo.mvvmexample.ui.CarListActivityTest

internal class CarListActionRobot(private val testSuite: CarListActivityTest) {

    fun clickCar(carName: String) {
        performClick(carName)
    }

    infix fun then(assertion: CarListAssertionRobot.() -> Unit): CarListAssertionRobot {
        return CarListAssertionRobot(testSuite).apply(assertion)
    }
}
