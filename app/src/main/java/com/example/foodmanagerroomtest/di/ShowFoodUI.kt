package com.example.foodmanagerroomtest.di

import com.example.foodmanagerroomtest.ui.showfood.viewmodel.ShowFoodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val showFoodUI = module {
    viewModel { ShowFoodViewModel(get()) }
}