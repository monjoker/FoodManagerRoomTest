package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.repository.FoodRepository

class UpdateFoodUseCaseImpl(override var foodRepository: FoodRepository) : UpdateFoodUseCase