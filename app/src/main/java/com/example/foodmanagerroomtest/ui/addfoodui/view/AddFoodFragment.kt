package com.example.foodmanagerroomtest.ui.addfoodui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.foodmanagerroomtest.R
import com.example.foodmanagerroomtest.databinding.FragmentAddFoodBinding
import com.example.foodmanagerroomtest.ui.addfoodui.viewmodel.AddFoodViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddFoodFragment() : Fragment(){
    private lateinit var bindingFragment: FragmentAddFoodBinding
    val addFoodViewModel by viewModel<AddFoodViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_add_food, container, false)
        val number = addFoodViewModel.number
        Toast.makeText(context,number.toString(),Toast.LENGTH_SHORT).show()
        return bindingFragment.root
    }
}