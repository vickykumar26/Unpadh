package com.unpadh.unpadhapp.api

import com.unpadh.unpadhapp.api.data.User
import com.unpadh.unpadhapp.utils.ApiEndPoints
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * Created by Gaurav Suyal on 19-02-2024.
 */

interface ApiService {

    @POST(ApiEndPoints.USER_LOGIN)
    suspend fun signInUser(
        @Query("Email") email : String,
        @Query("password") password : String
    ): List<User>


    @POST(ApiEndPoints.USER_LOGIN)
    suspend fun signUpUser(
        @Query("Username") userName : String,
        @Query("Email") email : String,
        @Query("Password") password : String,
        @Query("ConfirmPassword") confirmPassword : String
    ): List<User>
}