package com.unpadh.unpadhapp.onboarding_screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import com.unpadh.unpadhapp.MainActivity
import com.unpadh.unpadhapp.R
import com.unpadh.unpadhapp.databinding.ActivityOnBoardingScreensBinding
import com.unpadh.unpadhapp.onboarding_screens.adapter.ViewPagerAdapter
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesDataSource
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesRepository
import com.unpadh.unpadhapp.utils.AppConstants

class OnBoardingScreensActivity : AppCompatActivity() {

    lateinit var binding : ActivityOnBoardingScreensBinding


    private lateinit var sharedPreferencesRepository: SharedPreferencesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingScreensBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize SharedPreferencesRepository
        sharedPreferencesRepository = SharedPreferencesRepository(this)

        // Create an instance of the adapter that will manage the fragments
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // Set the adapter onto the ViewPager
        binding.viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(binding.viewPager)


        binding.skipText.setOnClickListener {
            moveToBusinessActivity()
        }
    }

    fun moveToBusinessActivity(){
        sharedPreferencesRepository.saveBooleanValue(AppConstants.IS_SPLASH_SCREEN_ALREADY_SHOWN, true)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    // Method to move to the next fragment
    fun moveToNextFragment() {
        Log.d("moveToNextFragment  ", "   ${binding.viewPager.currentItem.toString()},  ${binding.viewPager.adapter?.count.toString()}")
        // Check if the current fragment is the last one
        if (binding.viewPager.currentItem < binding.viewPager.adapter?.count ?: 0 +1 ) {
            // Move to the next fragment
            binding.viewPager.currentItem = binding.viewPager.currentItem + 1

        }
    }

}