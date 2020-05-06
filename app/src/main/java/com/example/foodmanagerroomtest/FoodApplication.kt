package com.example.foodmanagerroomtest

import android.app.Application
import android.util.Log
import com.example.foodmanagerroomtest.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoodApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            androidContext(this@FoodApplication)
            modules(listOf(roomModule, repositoryModule, useCaseModule, addFoodUI, showFoodUI))
        }
        Log.i("","")
    }
}