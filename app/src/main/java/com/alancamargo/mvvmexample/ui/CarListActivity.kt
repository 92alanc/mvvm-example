package com.alancamargo.mvvmexample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.alancamargo.mvvmexample.databinding.ActivityCarListBinding
import com.alancamargo.mvvmexample.navigation.CarDetailsActivityNavigation
import com.alancamargo.mvvmexample.ui.adapter.CarAdapter
import com.alancamargo.mvvmexample.ui.extensions.observeFlow
import com.alancamargo.mvvmexample.ui.model.UiCar
import com.alancamargo.mvvmexample.ui.viewmodel.CarListViewAction
import com.alancamargo.mvvmexample.ui.viewmodel.CarListViewModel
import com.alancamargo.mvvmexample.ui.viewmodel.CarListViewState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class CarListActivity : AppCompatActivity() {

    private var _binding: ActivityCarListBinding? = null

    private val binding: ActivityCarListBinding
        get() = _binding!!

    private val viewModel by viewModels<CarListViewModel>()

    private val adapter by lazy { CarAdapter(viewModel::onCarItemClicked) }

    @Inject
    lateinit var carDetailsActivityNavigation: CarDetailsActivityNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCarListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUi()
        observeViewModelFlows()
        viewModel.getCars()
    }

    private fun setUpUi() = with(binding) {
        recyclerView.adapter = adapter

        btExit.setOnClickListener {
            viewModel.onExitClicked()
        }

        btTryAgain.setOnClickListener {
            viewModel.getCars()
        }
    }

    private fun observeViewModelFlows() {
        observeFlow(viewModel.state, ::onStateChanged)
        observeFlow(viewModel.action, ::onAction)
    }

    private fun onStateChanged(state: CarListViewState) = with(state) {
        binding.progressBar.isVisible = isLoading
        binding.contentGroup.isVisible = cars != null
        binding.errorGroup.isVisible = errorType != null

        cars?.let(adapter::submitList)

        errorType?.let {
            binding.imgError.setImageResource(it.iconRes)
            binding.txtError.setText(it.textRes)
        }
    }

    private fun onAction(action: CarListViewAction) = when (action) {
        is CarListViewAction.NavigateToCarDetails -> navigateToCarDetails(action.car)
        is CarListViewAction.Finish -> finish()
    }

    private fun navigateToCarDetails(car: UiCar) {
        carDetailsActivityNavigation.startActivity(
            context = this,
            car = car
        )
    }
}
