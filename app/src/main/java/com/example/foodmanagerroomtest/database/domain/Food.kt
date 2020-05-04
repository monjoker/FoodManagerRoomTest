package com.example.foodmanagerroomtest.database.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class Food(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "description") var description: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}