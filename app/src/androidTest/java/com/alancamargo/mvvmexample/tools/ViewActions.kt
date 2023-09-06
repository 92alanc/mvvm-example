package com.alancamargo.mvvmexample.tools

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf

fun performClick(text: String) {
    onView(
        allOf(
            withText(text),
            isDisplayed()
        )
    ).perform(click())
}
