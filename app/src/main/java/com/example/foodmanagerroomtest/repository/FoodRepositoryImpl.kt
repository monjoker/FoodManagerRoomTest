package com.example.foodmanagerroomtest.repository

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.database.local.FoodDao

class FoodRepositoryImpl(override var foodDatabase: FoodDao) : FoodRepository {
    override fun getListFood() = foodDatabase.getListFoods()

    override fun deleteFood(food: Food, deleteExtension: () -> Unit) {
        foodDatabase.deleteFood(food)
        deleteExtension
    }

    override fun addFood(food: Food, insertExtension: ()-> Unit) {
        foodDatabase.insertFood(food)
        insertExtension
    }
}