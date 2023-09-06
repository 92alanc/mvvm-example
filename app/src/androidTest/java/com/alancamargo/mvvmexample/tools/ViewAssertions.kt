package com.alancamargo.mvvmexample.tools

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

fun assertTextIsDisplayed(text: String) {
    onView(withText(text)).check(matches(isDisplayed()))
}

fun recyclerViewItemCountIs(@IdRes recyclerViewId: Int, expectedCount: Int) {
    onView(withId(recyclerViewId)).check(withRecyclerViewItemCount(expectedCount))
}
