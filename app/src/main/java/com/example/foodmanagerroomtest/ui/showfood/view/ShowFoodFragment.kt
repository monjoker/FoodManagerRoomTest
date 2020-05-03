package com.example.foodmanagerroomtest.ui.showfood.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.foodmanagerroomtest.R
import com.example.foodmanagerroomtest.databinding.FragmentShowFoodBinding
import com.example.foodmanagerroomtest.ui.showfood.viewmodel.ShowFoodViewModel
import com.example.foodmanagerroomtest.usecase.ShowFoodUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowFoodFragment() : Fragment() {
    lateinit var bindingFragment: FragmentShowFoodBinding
    val showFoodViewModel by viewModel<ShowFoodViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_show_food, container, false)
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //showFoodViewModel.listFood
    }
}