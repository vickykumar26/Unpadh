package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.unpadh.unpadhapp.databinding.ActivityProfileSettingBinding

class ProfileSetting : AppCompatActivity() {

    private lateinit var binding: ActivityProfileSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrowBtn.setOnClickListener(){
            val intent = Intent(this@ProfileSetting, SettingScreen::class.java)
            startActivity(intent)
            finish()
        }

        binding.settingCancelBtn.setOnClickListener(){
            val intent = Intent(this@ProfileSetting, SettingScreen::class.java)
            startActivity(intent)
            finish()
        }

        userNameFocusListener()

        binding.settingSaveBtn.setOnClickListener { submitForm() }
    }

    private fun submitForm()
    {
        binding.textInputNewUsername.helperText = validUsername()

        val validUsername = binding.textInputNewUsername.helperText == null


        if (validUsername) {
            val intent = Intent(this@ProfileSetting, SettingScreen::class.java)
            startActivity(intent)
            finish()
        }
        else
            invalidForm()
    }

    private fun invalidForm()
    {
        var message = ""
        if(binding.textInputNewUsername.helperText != null)
            message += "\n\nnew username: " + binding.textInputNewUsername.helperText


    }

    private fun userNameFocusListener()
    {
        binding.etNewUsername.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputNewUsername.helperText = validUsername()
            }
        }
    }

    private fun validUsername(): String?
    {
        val emailText = binding.etNewUsername.text.toString()
        if(emailText.isNullOrEmpty() && emailText.isNullOrBlank())
        {
            return "this user name is alrady taken"
        }
        return null
    }
}