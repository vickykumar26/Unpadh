package com.unpadh.unpadhapp.api.data

import retrofit2.http.Query

data class SignUpUserRequest(
    val fname : String,
    val email : String,
    val mobileNumber : String,
    val password : String,
    val cPassword : String
)

data class ForgotPassword(
    val email : String,
    val password : String,
    val cpassword : String
)

data class SignInUserRequest(
    val email : String,
    val password : String
)
