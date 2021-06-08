package com.raywenderlich.training_with_room.dataStorage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo (name = "last_name")val lastName: String,
    val age: Int,
    val address: String,
    val height: Double,
    val profile: String
    ) {
    constructor(
        firstName: String,
        lastName: String,
        age: Int,
        address: String,
        height: Double,
        profile: String
    ):this(0,firstName,lastName,age,address,height,profile)
}