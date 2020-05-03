package com.example.foodmanagerroomtest.di

import com.example.foodmanagerroomtest.usecase.AddFoodUseCase
import com.example.foodmanagerroomtest.usecase.AddFoodUseCaseImpl
import com.example.foodmanagerroomtest.usecase.ShowFoodUseCase
import com.example.foodmanagerroomtest.usecase.ShowFoodUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<ShowFoodUseCase> { ShowFoodUseCaseImpl(get()) }
    single<AddFoodUseCase> { AddFoodUseCaseImpl(get()) }
}