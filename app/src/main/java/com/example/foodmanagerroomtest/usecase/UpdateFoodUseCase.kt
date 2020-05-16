package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.repository.FoodRepository

interface UpdateFoodUseCase {
    var foodRepository: FoodRepository
    suspend fun updateFood(food: Food)
}