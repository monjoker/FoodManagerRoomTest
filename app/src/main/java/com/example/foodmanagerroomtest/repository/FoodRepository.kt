package com.example.foodmanagerroomtest.repository

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.database.local.FoodDao

interface FoodRepository {
    var foodDatabase: FoodDao
    fun getListFood(): List<Food?>
    fun deleteFood(food: Food, deleteExtension: () -> Unit)
    fun addFood(food: Food, insertExtension: ()-> Unit)
}