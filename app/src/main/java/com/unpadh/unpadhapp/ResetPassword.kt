package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.unpadh.unpadhapp.api.UserViewModel
import com.unpadh.unpadhapp.api.repository.UserRepository
import com.unpadh.unpadhapp.databinding.ActivityResetPasswordBinding
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingScreensActivity
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesDataSource
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesRepository
import com.unpadh.unpadhapp.utils.AppConstants
import com.unpadh.unpadhapp.utils.Utils

class ResetPassword : AppCompatActivity() {
    lateinit var binding: ActivityResetPasswordBinding

    private lateinit var viewModel: UserViewModel
    private val userRepository = UserRepository()

    private lateinit var sharedPreferencesRepository: SharedPreferencesDataSource


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = UserViewModel(userRepository)

        // Initialize SharedPreferencesRepository
        sharedPreferencesRepository = SharedPreferencesRepository(this)

        resetpasswordFocusListener()
        resetcnfpasswordFocusListener()

        viewModel.users.observe(this) { users ->
            Log.d("apiCallForSignInUser if ", users.toString())

            // Update UI with users data
            Utils.hideDialog()
            if (users != null) {
                if (users.status == 201) {
                    Toast.makeText(this, users.message.toString(), Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@ResetPassword, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Something went wrong, please try again later.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Something went wrong, please try again later.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.resetBtn.setOnClickListener { submitForm() }
    }

    private fun submitForm()
    {
        binding.textInputResetPassword.helperText = validPassword()
        binding.textInputResetCnfPassword.helperText = validCnfPassword()

        val validPassword = binding.textInputResetPassword.helperText == null
        val validCnfPassword = binding.textInputResetCnfPassword.helperText == null

        if (validPassword && validCnfPassword) {
            val forgotEmail = sharedPreferencesRepository.getStringValue(AppConstants.FORGET_EMAIL, "")
            Utils.showDialog(this)
            forgotEmail?.let {
                viewModel.apiCallForForgotPassword(it,binding.etResetpaswd.text.toString(),binding.etResetcnfpaswd.text.toString())
            }
            /*var toast = Toast.makeText(this,"Account created successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@ResetPassword, MainActivity::class.java)
            startActivity(intent)
            finish()*/
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
            return "Please enter old password"
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
            return "Please enter new password"
        }
        /*if(!cnfpasswordText.equals(passwordText))
        {
            return "Must match both password"
        }*/
        return null
    }
}

