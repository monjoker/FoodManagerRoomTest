package com.example.foodmanagerroomtest.repository

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.database.local.FoodDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@ExperimentalCoroutinesApi
class FoodRepositoryImpl(override var foodDatabase: FoodDao) : FoodRepository {
    override fun getListFood(): Flow<MutableList<Food>> =
        foodDatabase.getListFoods().distinctUntilChanged()

    override suspend fun deleteFood(food: Food) = foodDatabase.deleteFood(food)

    override suspend fun addFood(food: Food) = foodDatabase.insertFood(food)

    override suspend fun updateFood(food: Food) = foodDatabase.updateFood(food)
}