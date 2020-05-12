package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.repository.FoodRepository
import kotlinx.coroutines.flow.Flow

interface ShowFoodUseCase {
    var foodRepository: FoodRepository
    fun getListFood() : Flow<List<Food>>
    suspend fun deleteFood(food: Food)
}