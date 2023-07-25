package com.alancamargo.mvvmexample.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alancamargo.mvvmexample.R

internal enum class UiErrorType(
    @StringRes val textRes: Int,
    @DrawableRes val iconRes: Int
) {

    NETWORK(
        textRes = R.string.message_network_error,
        iconRes = R.drawable.ic_network_error
    ),
    GENERIC(
        textRes = R.string.message_generic_error,
        iconRes = R.drawable.ic_generic_error
    )
}
