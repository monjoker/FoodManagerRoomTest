package com.example.foodmanagerroomtest.ui.showfoodui.viewmodel

import androidx.lifecycle.*
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.usecase.ShowFoodUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ShowFoodViewModel(private val showFoodUseCase: ShowFoodUseCase) : ViewModel() {
    private val liveListFood by lazy { MutableLiveData<MutableList<Food>>() }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            showFoodUseCase.getListFood().collect {
                liveListFood.postValue(it)
            }
        }
    }

    fun deleteFood(food: Food)= viewModelScope.launch(Dispatchers.IO){
        showFoodUseCase.deleteFood(food)
    }

    fun setListFood(owner: LifecycleOwner, observer: Observer<MutableList<Food>>) =
        liveListFood.observe(owner, observer)

    fun getListFood() = liveListFood.value
}