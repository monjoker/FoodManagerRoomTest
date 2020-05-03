package com.example.foodmanagerroomtest.di

import com.example.foodmanagerroomtest.database.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
    single { get<AppDatabase>().foodDao() }
}