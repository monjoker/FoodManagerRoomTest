package com.example.foodmanagerroomtest.database.local

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.foodmanagerroomtest.database.domain.Food
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM FOODS") fun getListFoods(): Flow<List<Food>>
    @Insert(onConflict = REPLACE) fun insertFood(food: Food?)
    @Update(onConflict = REPLACE) fun updateFood(food: Food?)
    @Delete fun deleteFood(food: Food?)
}