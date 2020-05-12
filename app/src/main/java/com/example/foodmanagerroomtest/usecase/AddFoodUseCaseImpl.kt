package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.repository.FoodRepository

class AddFoodUseCaseImpl(override val foodRepository: FoodRepository) : AddFoodUseCase {
    override suspend fun addFood(food: Food) =
        foodRepository.addFood(food)
}