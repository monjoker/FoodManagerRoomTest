package com.example.foodmanagerroomtest.di

import androidx.recyclerview.widget.ItemTouchHelper
import com.example.foodmanagerroomtest.ui.showfoodui.utils.FoodTouchHelperCallBack
import com.example.foodmanagerroomtest.ui.showfoodui.viewmodel.ShowFoodViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val showFoodUI = module {
    viewModel { ShowFoodViewModel(get()) }
}