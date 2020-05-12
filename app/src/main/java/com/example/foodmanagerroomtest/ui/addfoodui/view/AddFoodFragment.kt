package com.example.foodmanagerroomtest.ui.addfoodui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foodmanagerroomtest.R
import com.example.foodmanagerroomtest.databinding.FragmentAddFoodBinding
import com.example.foodmanagerroomtest.ui.addfoodui.viewmodel.AddFoodViewModel
import es.dmoral.toasty.Toasty
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddFoodFragment : Fragment() {
    private lateinit var bindingFragment: FragmentAddFoodBinding
    private val addFoodViewModel by viewModel<AddFoodViewModel>()
    private val submitAction by lazy {
        OnClickListener {
            addFoodViewModel.addFood(
                bindingFragment.food!!
            )
            Toasty.success(
                requireContext(),
                getString(R.string.add_food) + bindingFragment.food?.name + getString(R.string.success),
                Toasty.LENGTH_SHORT,
                true
            )::show
            foodNavigate.popBackStack()
        }
    }
    private val cancelAction by lazy { OnClickListener { foodNavigate.popBackStack() } }
    private val foodNavigate by lazy { findNavController() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_add_food, container, false)
        bindingFragment.food = get()
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(bindingFragment) {
            submidAddFood.setOnClickListener(submitAction)
            cancelAddFood.setOnClickListener(cancelAction)
        }
    }
}