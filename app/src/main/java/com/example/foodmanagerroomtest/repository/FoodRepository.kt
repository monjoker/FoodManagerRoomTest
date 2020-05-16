package com.example.foodmanagerroomtest.repository

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.database.local.FoodDao
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    var foodDatabase: FoodDao
    fun getListFood(): Flow<MutableList<Food>>
    suspend fun deleteFood(food: Food)
    suspend fun addFood(food: Food)
    suspend fun updateFood(food: Food)
}