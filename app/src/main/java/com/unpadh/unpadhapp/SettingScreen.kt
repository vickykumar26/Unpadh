package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.unpadh.unpadhapp.databinding.ActivityEmptyCartBinding
import com.unpadh.unpadhapp.databinding.ActivitySettingScreenBinding
import com.unpadh.unpadhapp.fragments.AccountFragment
import com.unpadh.unpadhapp.fragments.HomeFragment
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesDataSource
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesRepository
import com.unpadh.unpadhapp.utils.AppConstants

class SettingScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySettingScreenBinding

    private lateinit var sharedPreferencesRepository: SharedPreferencesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencesRepository = SharedPreferencesRepository(this)

        binding.backBtn.setOnClickListener {
            val intent = Intent(this@SettingScreen, AccountFragment::class.java)
            startActivity(intent)
            finish()
        }

        binding.passwordChangeBtn.setOnClickListener {
            val intent = Intent(this@SettingScreen, PasswordChangeScreen::class.java)
            startActivity(intent)
            finish()
        }


        binding.manageBtn.setOnClickListener(){
            val intent = Intent(this@SettingScreen, ProfileSetting::class.java)
            startActivity(intent)
            finish()
        }

        binding.signOutBtn.setOnClickListener(){
            sharedPreferencesRepository.clearAllData()
            sharedPreferencesRepository.saveBooleanValue(AppConstants.IS_SPLASH_SCREEN_ALREADY_SHOWN, true)
            val intent = Intent(this@SettingScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}