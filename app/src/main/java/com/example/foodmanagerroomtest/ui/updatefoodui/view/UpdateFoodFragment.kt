package com.example.foodmanagerroomtest.ui.updatefoodui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.foodmanagerroomtest.R
import com.example.foodmanagerroomtest.databinding.FragmentUpdateFoodBinding

class UpdateFoodFragment : Fragment() {
    private var bindingFragment: FragmentUpdateFoodBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_update_food, container, false)
        return bindingFragment?.root
    }
}