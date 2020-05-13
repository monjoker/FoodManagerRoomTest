package com.example.foodmanagerroomtest.ui.showfoodui.utils

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmanagerroomtest.ui.showfoodui.viewmodel.ShowFoodViewModel

class FoodTouchHelperCallBack(private val showFoodViewModel: ShowFoodViewModel) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return 0
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    }
}