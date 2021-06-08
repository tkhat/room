package com.raywenderlich.training_with_room.dataStorage

import androidx.room.Room
import com.raywenderlich.training_with_room.App.App

object DataService {

    val dbService by    lazy { db }

    private val db: UserDataBase = Room.databaseBuilder(
        App.context!!,
        UserDataBase::class.java,"data"
    ).build()
}