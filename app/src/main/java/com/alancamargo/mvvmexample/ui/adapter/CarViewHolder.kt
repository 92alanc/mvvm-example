package com.alancamargo.mvvmexample.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alancamargo.mvvmexample.databinding.ItemCarBinding
import com.alancamargo.mvvmexample.ui.model.UiCar

internal class CarViewHolder(
    private val binding: ItemCarBinding,
    private val onItemClick: (UiCar) -> Unit
) : ViewHolder(binding.root) {

    fun bindTo(car: UiCar) = with(binding) {
        txtName.text = car.name
        txtMake.text = car.make
        txtYear.text = car.year
        root.setOnClickListener {
            onItemClick(car)
        }
    }
}
