package com.example.foodmanagerroomtest.di

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.ui.addfoodui.viewmodel.AddFoodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addFoodUI = module {
    viewModel { AddFoodViewModel(get()) }
    factory { Food() }
}