package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.unpadh.unpadhapp.databinding.ActivityForgotPasswordBinding
import com.unpadh.unpadhapp.databinding.ActivityMainBinding

class ForgotPassword : AppCompatActivity() {

    lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListener()

        binding.forgotBtn.setOnClickListener { submitForm() }

    }

    private fun submitForm()
    {
        binding.textInputFemail.helperText = validEmail()

        val validEmail = binding.textInputFemail.helperText == null


        if (validEmail) {
            val intent = Intent(this@ForgotPassword, CheckEmail::class.java)
//            intent.putExtra("sendemail",binding.etFemail.text.toString())
            startActivity(intent)
            finish()
        }
        else
            invalidForm()
    }

    private fun invalidForm()
    {
        var message = ""
        if(binding.textInputFemail.helperText != null)
            message += "\n\nEmail: " + binding.textInputFemail.helperText

//        AlertDialog.Builder(this)
//            .setTitle("Invalid Form")
//            .setMessage(message)
//            .setPositiveButton("Okay"){ _,_ ->
//                // do nothing
//            }
//            .show()
    }

    private fun resetForm()
    {
        var message = "Email: " + binding.etFemail.text

        AlertDialog.Builder(this)
            .setTitle("Form submitted")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                binding.etFemail.text = null
            }
            .show()
    }

    private fun emailFocusListener()
    {
        binding.etFemail.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputFemail.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String?
    {
        val emailText = binding.etFemail.text.toString()
        if(emailText.isNullOrEmpty() && emailText.isNullOrBlank())
        {
            return "The email address you provided is not associated\nwith your account"
        }
        return null
    }
}