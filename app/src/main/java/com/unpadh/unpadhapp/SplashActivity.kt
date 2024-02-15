package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingFirstFragment
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingScreensActivity
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingSecondFragment

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            val intent = Intent(this, OnBoardingScreensActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}