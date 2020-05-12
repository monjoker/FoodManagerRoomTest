package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.repository.FoodRepository

class UpdateFoodUseCaseImpl(override var foodRepository: FoodRepository) : UpdateFoodUseCase {
    override suspend fun updateFood(food: Food) = foodRepository.updateFood(food)
}