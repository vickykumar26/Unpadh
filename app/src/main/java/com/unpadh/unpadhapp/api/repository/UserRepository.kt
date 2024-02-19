package com.unpadh.unpadhapp.api.repository

import com.unpadh.unpadhapp.api.ApiService
import com.unpadh.unpadhapp.api.data.User
import com.unpadh.unpadhapp.utils.Api_Base_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Gaurav Suyal on 19-02-2024.
 */

class UserRepository {
    private val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api_Base_URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

    suspend fun signInUser(email : String, password : String): List<User> {
        return apiService.signInUser(email,password)
    }

    suspend fun signUpUser(userName : String, email : String, password : String, confirmPassword : String): List<User> {
        return apiService.signUpUser(userName,email,password,confirmPassword)
    }

}