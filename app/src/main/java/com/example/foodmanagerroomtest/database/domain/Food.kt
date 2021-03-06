package com.example.foodmanagerroomtest.database.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "foods")
@Parcelize
data class Food(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "description") var description: String
) : Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
    constructor(): this("","")
    fun gan(food: Food){
        this.name = food.name
        this.description = food.description
    }
}