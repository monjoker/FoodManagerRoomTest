package com.example.foodmanagerroomtest.di

import com.example.foodmanagerroomtest.repository.FoodRepository
import com.example.foodmanagerroomtest.repository.FoodRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<FoodRepository> { FoodRepositoryImpl(get()) }
}