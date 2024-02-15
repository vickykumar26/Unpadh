package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.unpadh.unpadhapp.databinding.ActivityPasswordChangeScreenBinding

class PasswordChangeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordChangeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordChangeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrowBtn.setOnClickListener(){
            val intent = Intent(this@PasswordChangeScreen, SettingScreen::class.java)
            startActivity(intent)
            finish()
        }

        oldPasswordFocusListener()
        newPasswordFocusListener()
        cnfpasswordFocusListener()


        binding.paswdChangeBtn.setOnClickListener { submitForm() }

    }

    private fun submitForm()
    {
        binding.textInputOldPaswd.helperText = validOldPassword()
        binding.textInputNewPaswd.helperText = validPassword()
        binding.textInputNewCnfPaswd.helperText = validCnfPassword()

        val validOldPassword = binding.textInputOldPaswd.helperText == null
        val validPassword = binding.textInputNewPaswd.helperText == null
        val validCnfPassword = binding.textInputNewCnfPaswd.helperText == null

        if (validOldPassword && validPassword && validCnfPassword) {

            var toast = Toast.makeText(this,"Password change successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@PasswordChangeScreen, SettingScreen::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun oldPasswordFocusListener()
    {
        binding.etOldPaswd.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputOldPaswd.helperText = validCnfPassword()
            }
        }
    }

    private fun validOldPassword(): String?
    {
        val oldPasswordText = binding.etOldPaswd.text.toString()

        if(oldPasswordText.isEmpty())
        {
            return "Please enter old password"
        }
//        if (oldPasswordText.matches()){
//            return "Does not match with old password"
//        }

        return null
    }

    private fun newPasswordFocusListener()
    {
        binding.etNewPaswd.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputNewPaswd.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.etNewPaswd.text.toString()
        if(passwordText.isEmpty())
        {
            return "Please new enter password"
        }
        if(passwordText.length < 8)
        {
            return "Minimum 8 Character Password"
        }
        if(!passwordText.matches(".*[0-9].*".toRegex()))
        {
            return "Must Contain 1 Number"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Character (@#\$%^&+=)"
        }

        return null
    }

    private fun cnfpasswordFocusListener()
    {
        binding.etNewcnfpaswd.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputNewCnfPaswd.helperText = validCnfPassword()
            }
        }
    }

    private fun validCnfPassword(): String?
    {
        val cnfpasswordText = binding.etNewcnfpaswd.text.toString()
        val passwordText = binding.etNewPaswd.text.toString()
        if(cnfpasswordText.isEmpty())
        {
            return "Please enter confirm password"
        }
        if(!cnfpasswordText.equals(passwordText))
        {
            return "Must match both password"
        }
        return null
    }
}