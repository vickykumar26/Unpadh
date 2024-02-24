package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.lifecycleScope
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingFirstFragment
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingScreensActivity
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingSecondFragment
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesDataSource
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesRepository
import com.unpadh.unpadhapp.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds

    private lateinit var sharedPreferencesRepository: SharedPreferencesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        sharedPreferencesRepository = SharedPreferencesRepository(this)

        lifecycleScope.launch(Dispatchers.Main) {
            // Delay for splash screen timeout
            delay(SPLASH_TIME_OUT)

            // Determine the destination activity based on whether the splash screen has been shown before
            val destinationActivity = if (sharedPreferencesRepository.getBooleanValue(AppConstants.IS_SPLASH_SCREEN_ALREADY_SHOWN, false)) {
                val isAlreadyLoggedIn = sharedPreferencesRepository.getBooleanValue(AppConstants.IS_USER_LOGGED_IN,false)
                if (isAlreadyLoggedIn){
                    DashboardScreen::class.java
                }else {
                    MainActivity::class.java
                }
            } else {
                OnBoardingScreensActivity::class.java
            }

            // Start the destination activity
            val intent = Intent(this@SplashActivity, destinationActivity)
            startActivity(intent)
            finish()
        }
    }
}