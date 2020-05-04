package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import com.example.foodmanagerroomtest.database.domain.Food as Food

interface ShowFoodUseCase {
    var foodRepository: FoodRepository
    fun getListFood() : Flow<List<Food>>
    fun deleteFood(food: Food, deleteExtension: ()-> Unit)
}