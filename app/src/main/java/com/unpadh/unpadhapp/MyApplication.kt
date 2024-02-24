package com.unpadh.unpadhapp

import android.app.Application
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesRepository


/**
 * Created by Gaurav Suyal on 24-02-2024.
 */

class MyApplication : Application() {

    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate() {
        super.onCreate()

        // Initialize SharedPreferencesRepository
        sharedPreferencesRepository = SharedPreferencesRepository(applicationContext)
    }
}
