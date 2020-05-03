package com.example.foodmanagerroomtest.ui.showfood.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.usecase.ShowFoodUseCase

class ShowFoodViewModel(private var showFoodUseCase: ShowFoodUseCase) : ViewModel() {
    val listFood by lazy { MutableLiveData<List<Food>>() }
}