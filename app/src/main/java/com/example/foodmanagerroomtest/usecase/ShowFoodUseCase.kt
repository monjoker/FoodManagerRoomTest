package com.example.foodmanagerroomtest.usecase

import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.repository.FoodRepository

interface ShowFoodUseCase {
    var foodRepository: FoodRepository
    fun getListFood() : List<Food?>
    fun deleteFood(food: Food, deleteExtension: ()-> Unit)
}