package com.example.foodmanagerroomtest.ui.showfoodui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodmanagerroomtest.R
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.databinding.FragmentShowFoodBinding
import com.example.foodmanagerroomtest.ui.showfoodui.utils.FoodAdapter
import com.example.foodmanagerroomtest.ui.showfoodui.utils.FoodTouchHelperCallBack
import com.example.foodmanagerroomtest.ui.showfoodui.viewmodel.ShowFoodViewModel
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
class ShowFoodFragment : Fragment(), FoodAdapter.CallBackAdapter {
    private lateinit var bindingFragment: FragmentShowFoodBinding
    private val showFoodViewModel by viewModel<ShowFoodViewModel>()
    private val foodAdapter = get<FoodAdapter>()
    private val foodNavigate by lazy { findNavController() }
    private val foodTouchHelper by lazy { ItemTouchHelper(FoodTouchHelperCallBack(showFoodViewModel, foodAdapter)) }
    private val addClickBtn by lazy {
        View.OnClickListener {_->
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
        foodAdapter.callBackAdapter = this
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        foodAdapter.submitList(showFoodViewModel.getListFood())

        showFoodViewModel.setListFood(viewLifecycleOwner, Observer {
            foodAdapter.submitList(it)
        })
        val showFoodRecycler = bindingFragment.showFoodRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) //true
            //LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) //false
            adapter = foodAdapter
        }
        foodTouchHelper.attachToRecyclerView(showFoodRecycler)
        bindingFragment.addFoodBtn.setOnClickListener(addClickBtn)
    }

    override fun update(item: Food) {
        foodNavigate.navigate(ShowFoodFragmentDirections.actionShowFoodFragmentToUpdateFoodFragment(item))
    }

    override fun delete(item: Food) {
        showFoodViewModel.deleteFood(item)
        Toasty.success(
                requireContext(),
        resources.getString(R.string.delete) + " " + getString(R.string.success),
        Toasty.LENGTH_SHORT
        ).show()
    }
}