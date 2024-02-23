package com.unpadh.unpadhapp.api.repository

import com.unpadh.unpadhapp.api.ApiService
import com.unpadh.unpadhapp.api.data.RegistrationResponse
import com.unpadh.unpadhapp.api.data.SignInUserRequest
import com.unpadh.unpadhapp.api.data.SignUpUserRequest
import com.unpadh.unpadhapp.utils.Api_Base_URL
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

class UserRepository {

    private fun createOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Set logging level as per your requirement
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api_Base_URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient())
            .build()
        retrofit.create(ApiService::class.java)
    }

    suspend fun signInUser(request: SignInUserRequest): Response<RegistrationResponse> {
        return apiService.signInUser(request)
    }

    suspend fun signUpUser(request: SignUpUserRequest): Response<RegistrationResponse> {
        return apiService.signUpUser(request)
    }
}
