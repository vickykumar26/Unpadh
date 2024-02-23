package com.unpadh.unpadhapp.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unpadh.unpadhapp.api.data.RegistrationResponse
import com.unpadh.unpadhapp.api.data.SignInUserRequest
import com.unpadh.unpadhapp.api.data.SignUpUserRequest
import com.unpadh.unpadhapp.api.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableLiveData<RegistrationResponse?>()
    val users: LiveData<RegistrationResponse?>
        get() = _users

    fun apiCallForSignInUser(email : String, password : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.signInUser(SignInUserRequest(email,password))
            if (users.isSuccessful) {
                Log.d("apiCallForSignInUser if ",users.toString())

                users.body()?.let {
                    _users.postValue(it)
                }
            }else {
                Log.d("apiCallForSignInUser else ",users.toString())
                if (users.code() == 201) {
                    users.body()?.let {
                        _users.postValue(it)
                    }
                } else {
                    _users.postValue(null)
                }
            }
        }
    }

    fun apiCallForSignUpUser(userName : String, email : String,mobileNumber : String, password : String, confirmPassword : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.signUpUser(SignUpUserRequest(userName,email,mobileNumber,password,confirmPassword))
            if (users.isSuccessful){
                users.body()?.let {
                    _users.postValue(it)
                }
            }else{
                if (users.code() == 201) {
                    users.body()?.let {
                        _users.postValue(it)
                    }
                } else {
                    _users.postValue(null)
                }
            }
        }
    }
}