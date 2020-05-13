package com.example.foodmanagerroomtest.ui.showfoodui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.usecase.ShowFoodUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ShowFoodViewModel(private val showFoodUseCase: ShowFoodUseCase) : ViewModel() {
    val listFood by lazy { MutableLiveData<List<Food>>() }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            showFoodUseCase.getListFood().collect {
                listFood.postValue(it)
            }
        }
    }

    fun deleteFood(food: Food)= viewModelScope.launch(Dispatchers.IO){
        showFoodUseCase.deleteFood(food)
    }
}