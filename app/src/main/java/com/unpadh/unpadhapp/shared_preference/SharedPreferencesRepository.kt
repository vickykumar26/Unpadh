package com.unpadh.unpadhapp.shared_preference

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by Gaurav Suyal on 24-02-2024.
 */

class SharedPreferencesRepository(context: Context) : SharedPreferencesDataSource {

    companion object {
        private const val PREFERENCES_NAME = "your_preferences_name"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun saveStringValue(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getStringValue(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    override fun saveBooleanValue(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    override fun getBooleanValue(key: String, value: Boolean) : Boolean {
        return sharedPreferences.getBoolean(key, value) ?: value
    }

    override fun clearBannerImage(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override fun clearAllData() {
        sharedPreferences.edit().clear().apply()
    }
    // Implement other methods from SharedPreferencesDataSource
}