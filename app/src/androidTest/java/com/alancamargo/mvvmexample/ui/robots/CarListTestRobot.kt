package com.alancamargo.mvvmexample.ui.robots

import androidx.test.core.app.ActivityScenario
import com.alancamargo.mvvmexample.tools.stubCarResponseList
import com.alancamargo.mvvmexample.ui.CarListActivity
import com.alancamargo.mvvmexample.ui.CarListActivityTest
import io.mockk.coEvery
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.io.IOException

internal fun CarListActivityTest.given(
    block: CarListTestRobot.() -> Unit
): CarListTestRobot = CarListTestRobot(testSuite = this).apply(block)

internal class CarListTestRobot(private val testSuite: CarListActivityTest) {

    fun launchWithSuccess() {
        coEvery { testSuite.mockCarService.getCars() } returns stubCarResponseList()
        launch()
    }

    fun launchWithNetworkError() {
        coEvery { testSuite.mockCarService.getCars() } throws IOException()
        coEvery { testSuite.mockCarDb.getCars() } throws IllegalStateException()
        launch()
    }

    fun launchWithGenericError() {
        coEvery { testSuite.mockCarService.getCars() } throws IllegalStateException()
        coEvery { testSuite.mockCarDb.getCars() } throws IllegalStateException()
        launch()
    }

    infix fun withAction(action: CarListActionRobot.() -> Unit): CarListActionRobot {
        return CarListActionRobot(testSuite).apply(action)
    }

    infix fun then(assertion: CarListAssertionRobot.() -> Unit): CarListAssertionRobot {
        return CarListAssertionRobot(testSuite).apply(assertion)
    }

    private fun launch() {
        ActivityScenario.launch(CarListActivity::class.java)
        runBlocking { delay(timeMillis = 50) }
    }
}
