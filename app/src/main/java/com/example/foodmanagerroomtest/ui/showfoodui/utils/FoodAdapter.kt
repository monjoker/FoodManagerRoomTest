package com.example.foodmanagerroomtest.ui.showfoodui.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.databinding.ItemFoodBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class FoodAdapter :
    ListAdapter<Food, FoodAdapter.FoodViewHolder>(diff) {
    lateinit var callBackAdapter: CallBackAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder.createViewHolder(parent, viewType, callBackAdapter)

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.food = getItem(position)
        holder.bindViewHolder()
    }

    @ExperimentalCoroutinesApi
    class FoodViewHolder(
        private val itemBinding: ItemFoodBinding,
        private val callBackAdapter: CallBackAdapter
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        lateinit var food: Food
        fun bindViewHolder(){
            itemBinding.food = food
            itemBinding.executePendingBindings()
            itemBinding.updateBtn.setOnClickListener(updateAction)
            itemBinding.deleteBtn.setOnClickListener(deleteAction)
        }

        val updateAction by lazy {
            View.OnClickListener { _ ->
                //showFoodFragment.foodNavigate.navigate(ShowFoodFragmentDirections.actionShowFoodFragmentToUpdateFoodFragment(food))
                callBackAdapter.update(food)
            }
        }

        val deleteAction by lazy {
            View.OnClickListener {
                //showFoodViewModel.deleteFood(food)
                callBackAdapter.delete(food)
            }
        }

        companion object {
            fun createViewHolder(
                parent: ViewGroup,
                viewType: Int,
                callBackAdapter: CallBackAdapter
            ): FoodViewHolder = FoodViewHolder(
                ItemFoodBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), callBackAdapter
            )
        }
    }

    interface CallBackAdapter {
        fun update(item: Food)
        fun delete(item: Food)
    }

    companion object {
        val diff = object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean =
                oldItem == newItem
        }
    }
}