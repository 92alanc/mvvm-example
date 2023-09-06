package com.alancamargo.mvvmexample.ui

import com.alancamargo.mvvmexample.data.api.CarService
import com.alancamargo.mvvmexample.data.db.CarDb
import com.alancamargo.mvvmexample.navigation.CarDetailsActivityNavigation
import com.alancamargo.mvvmexample.ui.robots.given
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
internal class CarListActivityTest {

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var mockCarDetailsActivityNavigation: CarDetailsActivityNavigation

    @Inject
    lateinit var mockCarService: CarService

    @Inject
    lateinit var mockCarDb: CarDb

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun withSuccess_shouldDisplayCorrectNumberOfItems() {
        given {
            launchWithSuccess()
        } then {
            itemCountIs(expectedCount = 4)
        }
    }

    @Test
    fun withNetworkError_shouldDisplayNetworkError() {
        given {
            launchWithNetworkError()
        } then {
            networkErrorIsDisplayed()
        }
    }

    @Test
    fun withGenericError_shouldDisplayGenericError() {
        given {
            launchWithGenericError()
        } then {
            genericErrorIsDisplayed()
        }
    }

    @Test
    fun clickCarItem_shouldNavigateToCarDetails() {
        given {
            launchWithSuccess()
        } withAction {
            clickCar(carName = "Golzão quadrado")
        } then {
            navigateToCarDetails()
        }
    }
}
