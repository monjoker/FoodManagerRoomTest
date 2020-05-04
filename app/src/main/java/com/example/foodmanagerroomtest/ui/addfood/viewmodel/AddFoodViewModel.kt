package com.example.foodmanagerroomtest.ui.addfood.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.foodmanagerroomtest.usecase.AddFoodUseCase

class AddFoodViewModel( var addFoodUseCase: AddFoodUseCase) : ViewModel(){
    var number = 0

    init {
        Log.i("Da load AddFoodViewmodel", "------------------------")
    }
}