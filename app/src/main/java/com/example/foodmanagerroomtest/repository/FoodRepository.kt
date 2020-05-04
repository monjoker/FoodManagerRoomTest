package com.example.foodmanagerroomtest.repository

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.database.local.FoodDao
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    var foodDatabase: FoodDao
    fun getListFood(): Flow<List<Food>>
    fun deleteFood(food: Food, deleteExtension: () -> Unit)
    fun addFood(food: Food, insertExtension: ()-> Unit)
}