package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.repository.FoodRepository

interface UpdateFoodUseCase {
    var foodRepository: FoodRepository
}