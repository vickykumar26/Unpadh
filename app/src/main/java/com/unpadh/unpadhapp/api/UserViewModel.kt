package com.unpadh.unpadhapp.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unpadh.unpadhapp.api.data.RegistrationResponse
import com.unpadh.unpadhapp.api.data.User
import com.unpadh.unpadhapp.api.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableLiveData<RegistrationResponse>()
    val users: LiveData<RegistrationResponse>
        get() = _users

    fun apiCallForSignInUser(email : String, password : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.signInUser(email,password)
            users.body()?.let {
                _users.postValue(it)
            }

        }
    }

    fun apiCallForSignUpUser(userName : String, email : String,mobileNumber : String, password : String, confirmPassword : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.signUpUser(userName,email,mobileNumber,password,confirmPassword)
            users.body()?.let {
                _users.postValue(it)
            }
        }
    }
}