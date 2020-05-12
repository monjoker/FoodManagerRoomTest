package com.example.foodmanagerroomtest.di

import com.example.foodmanagerroomtest.usecase.*
import org.koin.dsl.module

val useCaseModule = module {
    single<ShowFoodUseCase> { ShowFoodUseCaseImpl(get()) }
    single<AddFoodUseCase> { AddFoodUseCaseImpl(get()) }
    single<UpdateFoodUseCase> { UpdateFoodUseCaseImpl(get()) }
}