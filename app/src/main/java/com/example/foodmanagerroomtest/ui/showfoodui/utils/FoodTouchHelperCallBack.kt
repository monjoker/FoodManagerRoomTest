package com.example.foodmanagerroomtest.ui.showfoodui.utils

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.ui.showfoodui.viewmodel.ShowFoodViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class FoodTouchHelperCallBack(
    private var showFoodViewModel: ShowFoodViewModel,
    private var showFoodAdapter: FoodAdapter
) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlag = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(
            dragFlag,
            swipeFlag
        )
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val listFood: MutableList<Food> = showFoodViewModel.getListFood()!!
        val foodViewHolder = viewHolder as FoodAdapter.FoodViewHolder
        if (direction == ItemTouchHelper.RIGHT){
            //showFoodViewModel.deleteFood(listFood[viewHolder.adapterPosition])
            foodViewHolder.deleteAction.onClick(viewHolder.itemView)
        }
        else if(direction == ItemTouchHelper.LEFT)
            foodViewHolder.updateAction.onClick(viewHolder.itemView)
        //Cần phải submit lại list
        showFoodAdapter.submitList(listFood)
    }
}