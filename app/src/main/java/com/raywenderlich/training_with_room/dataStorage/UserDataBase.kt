package com.raywenderlich.training_with_room.dataStorage

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)

abstract class UserDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
}