package com.unpadh.unpadhapp.api

import com.unpadh.unpadhapp.api.data.ForgotPassword
import com.unpadh.unpadhapp.api.data.RegistrationResponse
import com.unpadh.unpadhapp.api.data.SignInUserRequest
import com.unpadh.unpadhapp.api.data.SignUpUserRequest
import com.unpadh.unpadhapp.utils.ApiEndPoints
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiService {

    @POST(ApiEndPoints.USER_LOGIN)
    suspend fun signInUser(
        @Body request: SignInUserRequest
    ): Response<RegistrationResponse>


    @POST(ApiEndPoints.USER_REGISTER)
    suspend fun signUpUser(
        @Body request : SignUpUserRequest
    ): Response<RegistrationResponse>

    @PUT(ApiEndPoints.FORGOT_PASSWORD)
    suspend fun forgetPassword(
        @Body request : ForgotPassword
    ): Response<RegistrationResponse>
}