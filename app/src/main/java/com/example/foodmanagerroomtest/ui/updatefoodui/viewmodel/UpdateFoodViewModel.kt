package com.example.foodmanagerroomtest.ui.updatefoodui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.usecase.UpdateFoodUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateFoodViewModel(private val updatateFoodUseCase: UpdateFoodUseCase) : ViewModel() {
    lateinit var food: Food
    fun updateFood() = viewModelScope.launch(Dispatchers.IO) {
        updatateFoodUseCase.updateFood(food)
    }
}