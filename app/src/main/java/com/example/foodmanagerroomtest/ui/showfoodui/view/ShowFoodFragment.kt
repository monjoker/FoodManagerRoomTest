package com.example.foodmanagerroomtest.ui.showfoodui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodmanagerroomtest.R
import com.example.foodmanagerroomtest.databinding.FragmentShowFoodBinding
import com.example.foodmanagerroomtest.ui.showfoodui.utils.FoodAdapter
import com.example.foodmanagerroomtest.ui.showfoodui.viewmodel.ShowFoodViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class ShowFoodFragment : Fragment() {
    private lateinit var bindingFragment: FragmentShowFoodBinding
    private val showFoodViewModel by viewModel<ShowFoodViewModel>()
    private val foodAdapter by lazy { FoodAdapter() }
    val foodNavigate by lazy { findNavController() }
    private val addClickBtn by lazy {
        View.OnClickListener {
            foodNavigate.navigate(
                ShowFoodFragmentDirections.actionShowFoodFragmentToAddFoodFragment()
            )
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_show_food, container, false)
        foodAdapter.setFrag(this)
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        foodAdapter.submitList(showFoodViewModel.listFood.value)
        showFoodViewModel.listFood.observe(viewLifecycleOwner, Observer {
            foodAdapter.submitList(it)
        })
        bindingFragment.showFoodRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) //true
            //LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) //false
            adapter = foodAdapter
        }
        bindingFragment.addFoodBtn.setOnClickListener(addClickBtn)
    }
}