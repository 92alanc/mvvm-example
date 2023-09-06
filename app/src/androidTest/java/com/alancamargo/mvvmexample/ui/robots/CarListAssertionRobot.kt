package com.alancamargo.mvvmexample.ui.robots

import androidx.appcompat.app.AppCompatActivity
import com.alancamargo.mvvmexample.R
import com.alancamargo.mvvmexample.tools.assertTextIsDisplayed
import com.alancamargo.mvvmexample.tools.recyclerViewItemCountIs
import com.alancamargo.mvvmexample.ui.CarListActivityTest
import com.google.common.truth.Truth.assertThat
import io.mockk.verify

internal class CarListAssertionRobot(private val testSuite: CarListActivityTest) {

    fun navigateToCarDetails() {
        verify {
            testSuite.mockCarDetailsActivityNavigation.startActivity(
                context = any(),
                car = any()
            )
        }
    }

    fun networkErrorIsDisplayed() {
        assertTextIsDisplayed(text = "Ta com o cabo de rede conectado? Desliga e liga o modem")
    }

    fun genericErrorIsDisplayed() {
        assertTextIsDisplayed(text = "Deu ruim em alguma coisa ae…")
    }

    fun itemCountIs(expectedCount: Int) {
        recyclerViewItemCountIs(R.id.recyclerView, expectedCount)
    }
}
