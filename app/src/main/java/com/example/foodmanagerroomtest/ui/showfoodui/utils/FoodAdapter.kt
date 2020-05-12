package com.example.foodmanagerroomtest.ui.showfoodui.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.databinding.ItemFoodBinding
import com.example.foodmanagerroomtest.ui.showfoodui.view.ShowFoodFragment
import com.example.foodmanagerroomtest.ui.showfoodui.view.ShowFoodFragmentDirections
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class FoodAdapter : ListAdapter<Food, FoodAdapter.FoodViewHolder>(diff) {
    private lateinit var showFoodFragment: ShowFoodFragment

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder.createViewHolder(parent, viewType, showFoodFragment)

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindViewHolder(getItem(position))
    }

    fun setFrag(showFoodFragment: ShowFoodFragment){
        this.showFoodFragment = showFoodFragment
    }

    @ExperimentalCoroutinesApi
    class FoodViewHolder(
        private val itemBinding: ItemFoodBinding,
        private val showFoodFragment: ShowFoodFragment
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bindViewHolder(item: Food?) = with(item){
            itemBinding.food = this
            itemBinding.updateBtn.setOnClickListener(updateAction)
        }

        private val updateAction by lazy {
            View.OnClickListener {
                showFoodFragment.foodNavigate.navigate(
                    ShowFoodFragmentDirections.actionShowFoodFragmentToUpdateFoodFragment()
                )
            }
        }

        companion object {
            fun createViewHolder(
                parent: ViewGroup,
                viewType: Int,
                showFoodFragment: ShowFoodFragment
            ): FoodViewHolder = FoodViewHolder(
                ItemFoodBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), showFoodFragment
            )
        }
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