package com.unpadh.unpadhapp.api.repository

import com.unpadh.unpadhapp.api.ApiService
import com.unpadh.unpadhapp.api.data.RegistrationResponse
import com.unpadh.unpadhapp.api.data.User
import com.unpadh.unpadhapp.utils.Api_Base_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {
    private val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api_Base_URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

    suspend fun signInUser(email : String, password : String): Response<RegistrationResponse> {
        return apiService.signInUser(email,password)
    }

    suspend fun signUpUser(userName : String, email : String,mobileNumber : String, password : String, confirmPassword : String): Response<RegistrationResponse> {
        return apiService.signUpUser(userName,email,mobileNumber,password,confirmPassword)
    }

}