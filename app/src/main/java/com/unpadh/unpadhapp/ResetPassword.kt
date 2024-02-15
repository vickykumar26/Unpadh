package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.unpadh.unpadhapp.databinding.ActivityResetPasswordBinding

class ResetPassword : AppCompatActivity() {
    lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        resetpasswordFocusListener()
        resetcnfpasswordFocusListener()


        binding.resetBtn.setOnClickListener { submitForm() }
    }

    private fun submitForm()
    {
        binding.textInputResetPassword.helperText = validPassword()
        binding.textInputResetCnfPassword.helperText = validCnfPassword()

        val validPassword = binding.textInputResetPassword.helperText == null
        val validCnfPassword = binding.textInputResetCnfPassword.helperText == null

        if (validPassword && validCnfPassword) {

            var toast = Toast.makeText(this,"Account created successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@ResetPassword, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun resetpasswordFocusListener()
    {
        binding.etResetpaswd.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputResetPassword.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.etResetpaswd.text.toString()
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

    private fun resetcnfpasswordFocusListener()
    {
        binding.etResetcnfpaswd.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputResetCnfPassword.helperText = validCnfPassword()
            }
        }
    }

    private fun validCnfPassword(): String?
    {
        val cnfpasswordText = binding.etResetcnfpaswd.text.toString()
        val passwordText = binding.etResetpaswd.text.toString()
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

