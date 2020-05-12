package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.repository.FoodRepository

interface AddFoodUseCase {
    val foodRepository: FoodRepository
    suspend fun addFood(food: Food)
}