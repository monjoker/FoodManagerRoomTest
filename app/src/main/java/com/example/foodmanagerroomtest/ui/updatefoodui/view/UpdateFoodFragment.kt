package com.example.foodmanagerroomtest.ui.updatefoodui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.foodmanagerroomtest.R
import com.example.foodmanagerroomtest.databinding.FragmentUpdateFoodBinding
import com.example.foodmanagerroomtest.ui.updatefoodui.viewmodel.UpdateFoodViewModel
import es.dmoral.toasty.Toasty
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdateFoodFragment : Fragment() {
    private lateinit var bindingFragment: FragmentUpdateFoodBinding
    private val updateFoodViewModel by viewModel<UpdateFoodViewModel>()
    private val submitAction by lazy {
        View.OnClickListener { _ ->
            val foodOutput = bindingFragment.foodOutput!!
            val foodInput = bindingFragment.foodInput!!
            foodInput.gan(foodOutput)
            updateFoodViewModel.food = foodInput
            updateFoodViewModel.updateFood()
            Toasty.success(
                requireContext(),
                getString(R.string.update_food) + foodInput.name + getString(R.string.success),
                Toasty.LENGTH_SHORT,
                true
            )::show
            foodNavigate.popBackStack()
        }
    }
    private val cancelAction by lazy { View.OnClickListener { _ -> foodNavigate.popBackStack() } }
    private val foodNavigate by lazy { findNavController() }
    private val safeArgs by navArgs<UpdateFoodFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_update_food, container, false)
        updateFoodViewModel.food = safeArgs.food
        bindingFragment.foodInput = updateFoodViewModel.food
        bindingFragment.foodOutput = get()
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(bindingFragment){
            bindingFragment.foodInput = updateFoodViewModel.food
            updateFood.setOnClickListener(submitAction)
            cancleUpdateFood.setOnClickListener(cancelAction)
        }
    }
}