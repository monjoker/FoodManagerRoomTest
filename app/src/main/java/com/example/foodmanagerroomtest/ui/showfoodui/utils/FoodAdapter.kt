package com.example.foodmanagerroomtest.ui.showfoodui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.databinding.ItemFoodBinding
import java.util.zip.Inflater

class FoodAdapter : ListAdapter<Food, FoodAdapter.FoodViewHolder>(diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder.CreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindViewHolder(getItem(position))
    }

    class FoodViewHolder(private val itemBinding: ItemFoodBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bindViewHolder(item: Food?) {
            itemBinding.food = item
        }

        companion object {
            fun CreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder = FoodViewHolder(
                ItemFoodBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
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