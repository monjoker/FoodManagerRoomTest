package com.example.foodmanagerroomtest.di

import com.example.foodmanagerroomtest.repository.FoodRepository
import com.example.foodmanagerroomtest.repository.FoodRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val repositoryModule = module {
    single<FoodRepository> { FoodRepositoryImpl(get()) }
}