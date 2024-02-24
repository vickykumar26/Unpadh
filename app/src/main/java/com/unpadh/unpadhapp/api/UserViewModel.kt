package com.unpadh.unpadhapp.api

import android.database.Observable
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.unpadh.unpadhapp.api.data.ForgotPassword
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
                val errorMessage = users.errorBody()?.string()
                Log.d("apiCallForSignUpUser else", errorMessage ?: "Error body is null")
                if (errorMessage != null && errorMessage.isNotEmpty()) {
                    // Parse error message from the response body
                    try {
                        val errorResponse = Gson().fromJson(errorMessage, RegistrationResponse::class.java)
                        _users.postValue(errorResponse)
                    } catch (e: JsonParseException) {
                        // Failed to parse error message, post null to indicate error
                        _users.postValue(null)
                    }
                } else {
                    // No error message in the response body, post null to indicate error
                    _users.postValue(null)
                }
                /*if (users.code() == 201) {
                    users.body()?.let {
                        _users.postValue(it)
                    }
                } else {
                    _users.postValue(null)
                }*/
            }
        }
    }

    /*fun apiCallForSignUpUser(userName : String, email : String,mobileNumber : String, password : String, confirmPassword : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.signUpUser(SignUpUserRequest(userName,email,mobileNumber,password,confirmPassword))
            if (users.isSuccessful){
                users.body()?.let {
                    _users.postValue(it)
                }
            }else{
                Log.d("apiCallForSignInUser else ",users.errorBody().toString() +"\n ${users.toString()}")

                if (users.body()?.message == null){
                    _users.postValue(null)
                }else{
                    users.body()?.let {
                        _users.postValue(it)
                    }
                }
            }
        }
    }*/

    fun apiCallForSignUpUser(userName: String, email: String, mobileNumber: String, password: String, confirmPassword: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.signUpUser(SignUpUserRequest(userName, email, mobileNumber, password, confirmPassword))
            if (users.isSuccessful) {
                users.body()?.let {
                    _users.postValue(it)
                }
            } else {
                val errorMessage = users.errorBody()?.string()
                Log.d("apiCallForSignUpUser else", errorMessage ?: "Error body is null")
                if (errorMessage != null && errorMessage.isNotEmpty()) {
                    // Parse error message from the response body
                    try {
                        val errorResponse = Gson().fromJson(errorMessage, RegistrationResponse::class.java)
                        _users.postValue(errorResponse)
                    } catch (e: JsonParseException) {
                        // Failed to parse error message, post null to indicate error
                        _users.postValue(null)
                    }
                } else {
                    // No error message in the response body, post null to indicate error
                    _users.postValue(null)
                }
            }
        }
    }



    fun apiCallForForgotPassword(email: String, password: String, confirmPassword: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.forgetUserPassword(ForgotPassword(email, password, confirmPassword))
            if (users.isSuccessful) {
                users.body()?.let {
                    _users.postValue(it)
                }
            } else {
                val errorMessage = users.errorBody()?.string()
                Log.d("apiCallForSignUpUser else", errorMessage ?: "Error body is null")
                if (errorMessage != null && errorMessage.isNotEmpty()) {
                    // Parse error message from the response body
                    try {
                        val errorResponse = Gson().fromJson(errorMessage, RegistrationResponse::class.java)
                        _users.postValue(errorResponse)
                    } catch (e: JsonParseException) {
                        // Failed to parse error message, post null to indicate error
                        _users.postValue(null)
                    }
                } else {
                    // No error message in the response body, post null to indicate error
                    _users.postValue(null)
                }
            }
        }
    }

}