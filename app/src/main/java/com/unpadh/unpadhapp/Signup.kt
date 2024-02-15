package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.textfield.TextInputLayout
import com.unpadh.unpadhapp.databinding.ActivitySignupBinding

class Signup : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

            // Your remaining code here after validation

        binding.loginOpt.setOnClickListener(){
            val intent = Intent(this@Signup, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

//        ArrayAdapter.createFromResource(
//            applicationContext,
//            R.array.profession,
//            R.layout.drop_down_item
//        )
//            .also {
//                binding.edtbusinesstype.adapter = it
//                it.setDropDownViewResource(R.layout.drop_down_item)
//            }
//
//        binding.spLayout.setOnClickListener {
//            binding.edtbusinesstype.performClick()
//        }
//
//
//        binding.edtbusinesstype.onItemSelectedListener = object :
//            AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                applicationContext?.getColor(R.color.black)
//                    ?.let {
//                        if (p1 is TextView) {
//                            p1.setTextColor(it)
//                            p1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
//                        }
//                    }
//                p0?.getItemAtPosition(p2).let {
//                    binding.spLayout.text = it.toString()
//                }
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//
//            }
//        }


        nameFocusListener()
        emailFocusListener()
        passwordFocusListener()
        cnfpasswordFocusListener()
        phoneFocusListener()

        binding.signupBtn.setOnClickListener { submitForm() }
    }


    private fun submitForm()
    {
        binding.textInputName.helperText = validName()
        binding.textInputEmail.helperText = validEmail()
        binding.textInputPassword.helperText = validPassword()
        binding.textInputCnfpassword.helperText = validCnfPassword()
        binding.textInputPhone.helperText = validPhone()

        val validName = binding.textInputName.helperText == null
        val validEmail = binding.textInputEmail.helperText == null
        val validPassword = binding.textInputPassword.helperText == null
        val validCnfPassword = binding.textInputCnfpassword.helperText == null
        val validPhone = binding.textInputPhone.helperText == null

        if (validName && validEmail && validPassword && validCnfPassword && validPhone) {
            
            val intent = Intent(this@Signup, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun nameFocusListener()
    {
        binding.etName.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputName.helperText = validName()
            }
        }
    }

    private fun validName(): String?
    {
        val nameText = binding.etName.text.toString()
        if(nameText.isEmpty())
        {
            return "Please enter your name"
        }
        return null
    }


    private fun emailFocusListener()
    {
        binding.etEmail.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputEmail.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String?
    {
        val emailText = binding.etEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Please enter valid email"
        }
        return null
    }

    private fun passwordFocusListener()
    {
        binding.etPaswd.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputPassword.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.etPaswd.text.toString()
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
        binding.etCnfpaswd.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputCnfpassword.helperText = validCnfPassword()
            }
        }
    }

    private fun validCnfPassword(): String?
    {
        val cnfpasswordText = binding.etCnfpaswd.text.toString()
        val passwordText = binding.etPaswd.text.toString()
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
    private fun phoneFocusListener()
    {
        binding.etPhone.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputPhone.helperText = validPhone()
            }
        }
    }

    private fun validPhone(): String?
    {
        val phoneText = binding.etPhone.text.toString()
        if(!phoneText.matches(".*[0-9].*".toRegex()))
        {
            return "Please enter valid mobile no"
        }
        if(phoneText.length != 10)
        {
            return "Please enter valid mobile no"
        }
        return null
    }

}
