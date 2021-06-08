package com.raywenderlich.training_with_room.ui.addUserFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.training_with_room.dataStorage.DataService
import com.raywenderlich.training_with_room.dataStorage.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddUserViewModel : ViewModel() {



    fun put(user: User){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                DataService.dbService.userDao().insertUser(user)
            }
        }

    }





}