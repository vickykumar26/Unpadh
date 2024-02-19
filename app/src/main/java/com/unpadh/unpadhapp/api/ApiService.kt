package com.unpadh.unpadhapp.api

import com.unpadh.unpadhapp.api.data.RegistrationResponse
import com.unpadh.unpadhapp.api.data.User
import com.unpadh.unpadhapp.utils.ApiEndPoints
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * Created by Gaurav Suyal on 19-02-2024.
 */

interface ApiService {

    @POST(ApiEndPoints.USER_LOGIN)
    suspend fun signInUser(
        @Query("email") email : String,
        @Query("password") password : String
    ): Response<RegistrationResponse>


    @POST(ApiEndPoints.USER_REGISTER)
    suspend fun signUpUser(
        @Query("fname") userName : String,
        @Query("email") email : String,
        @Query("mobileNumber") mobileNumber : String,
        @Query("password") password : String,
        @Query("cPassword") confirmPassword : String
    ): Response<RegistrationResponse>
}