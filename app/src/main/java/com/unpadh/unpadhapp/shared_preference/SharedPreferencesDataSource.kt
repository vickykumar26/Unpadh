package com.unpadh.unpadhapp.shared_preference

import android.content.Context
import android.util.Log


/**
 * Created by Gaurav Suyal on 24-02-2024.
 */

interface SharedPreferencesDataSource {
    fun saveStringValue(key: String, value: String)
    fun getStringValue(key: String, defaultValue: String): String
    fun saveBooleanValue(key: String, value : Boolean)
    fun getBooleanValue(key: String, value : Boolean) : Boolean
    fun clearBannerImage(key: String)
    fun clearAllData()
    // Add more methods for other data types as needed
}
