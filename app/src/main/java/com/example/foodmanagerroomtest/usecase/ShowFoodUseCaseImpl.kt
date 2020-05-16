package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.repository.FoodRepository
import kotlinx.coroutines.flow.Flow

class ShowFoodUseCaseImpl(override var foodRepository: FoodRepository) : ShowFoodUseCase {
    override fun getListFood() = foodRepository.getListFood()
    override suspend fun deleteFood(food: Food) =
        foodRepository.deleteFood(food)
}