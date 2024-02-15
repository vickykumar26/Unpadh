package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.unpadh.unpadhapp.databinding.ActivityEmptyCartBinding
import com.unpadh.unpadhapp.databinding.ActivitySettingScreenBinding
import com.unpadh.unpadhapp.fragments.AccountFragment
import com.unpadh.unpadhapp.fragments.HomeFragment

class SettingScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySettingScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
            val intent = Intent(this@SettingScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}