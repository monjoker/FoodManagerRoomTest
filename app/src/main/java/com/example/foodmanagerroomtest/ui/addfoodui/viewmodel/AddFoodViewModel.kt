package com.example.foodmanagerroomtest.ui.addfoodui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.usecase.AddFoodUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Suppress("RedundantWith")
class AddFoodViewModel(private val addFoodUseCase: AddFoodUseCase) :ViewModel(){
    fun addFood(food: Food) = viewModelScope.launch(Dispatchers.IO) {
        addFoodUseCase.addFood(food)
    }
}