package com.alancamargo.mvvmexample.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiCar(
    val id: String,
    val name: String,
    val make: String,
    val year: String
) : Parcelable
