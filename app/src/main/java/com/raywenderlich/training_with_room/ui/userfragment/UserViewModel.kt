package com.raywenderlich.training_with_room.ui.userfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.training_with_room.dataStorage.DataService
import com.raywenderlich.training_with_room.dataStorage.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel : ViewModel() {

    var users = MutableLiveData<List<User>>()



    fun showUser(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
               val data = DataService.dbService.userDao().getAll()
                users.postValue(data)
            }

        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                DataService.dbService.userDao().delete(user)
                showUser()
            }
        }
    }

}