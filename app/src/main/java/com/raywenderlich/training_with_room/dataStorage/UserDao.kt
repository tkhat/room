package com.raywenderlich.training_with_room.dataStorage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {


    @Query("SELECT * FROM user")
    suspend fun getAll():List<User>



    @Insert
    suspend fun insertUser(vararg user: User)

    @Delete
    suspend fun delete(user: User)

}