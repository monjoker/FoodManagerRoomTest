package com.example.foodmanagerroomtest.di

import com.example.foodmanagerroomtest.ui.updatefoodui.viewmodel.UpdateFoodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val updateFoodUI = module {
    viewModel { UpdateFoodViewModel(get()) }
}