package com.example.foodmanagerroomtest.database.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodmanagerroomtest.database.domain.Food
import com.example.foodmanagerroomtest.database.local.AppDatabase.Companion.VERSION_DATABASE

@Database(entities = [Food::class], version = VERSION_DATABASE, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao

    companion object {
        const val VERSION_DATABASE: Int = 1
        private const val DB_NAME = "AppDatabase.db"
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: build(context).also { instance = it }
        }

        private fun build(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).build()
    }
}