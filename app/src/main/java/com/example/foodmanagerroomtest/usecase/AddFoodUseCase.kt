package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.repository.FoodRepository

interface AddFoodUseCase {
    val foodRepository: FoodRepository
    fun addFood(food: Food, insertExtension: () -> Unit)
}