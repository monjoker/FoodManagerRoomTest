package com.example.foodmanagerroomtest.database.local

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.foodmanagerroomtest.database.domain.Food
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM FOODS")
    fun getListFoods(): Flow<MutableList<Food>>

    @Insert(onConflict = REPLACE)
    suspend fun insertFood(food: Food)

    @Update(onConflict = REPLACE)
    suspend fun updateFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)
}