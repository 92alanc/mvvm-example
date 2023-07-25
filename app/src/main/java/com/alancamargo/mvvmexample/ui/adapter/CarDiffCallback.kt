package com.alancamargo.mvvmexample.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alancamargo.mvvmexample.ui.model.UiCar

internal class CarDiffCallback : DiffUtil.ItemCallback<UiCar>() {

    override fun areItemsTheSame(oldItem: UiCar, newItem: UiCar): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiCar, newItem: UiCar): Boolean {
        return oldItem == newItem
    }
}
