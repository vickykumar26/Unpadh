package com.unpadh.unpadhapp.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unpadh.unpadhapp.api.data.User
import com.unpadh.unpadhapp.api.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Created by Gaurav Suyal on 19-02-2024.
 */

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    fun apiCallForSignInUser(email : String, password : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.signInUser(email,password)
            _users.postValue(users)
        }
    }


    fun apiCallForSignUpUser(userName : String, email : String, password : String, confirmPassword : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.signUpUser(userName,email,password,confirmPassword)
            _users.postValue(users)
        }
    }
}