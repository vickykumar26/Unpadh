package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.unpadh.unpadhapp.api.UserViewModel
import com.unpadh.unpadhapp.api.repository.UserRepository
import com.unpadh.unpadhapp.databinding.ActivityMainBinding
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingFirstFragment
import com.unpadh.unpadhapp.utils.Utils
import java.net.Inet4Address

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: UserViewModel
    private val userRepository = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = UserViewModel(userRepository)

        viewModel.users.observe(this) { users ->
            Log.d("apiCallForSignInUser if ",users.toString())

            // Update UI with users data
            Utils.hideDialog()
            if (users != null){
                Toast.makeText(this, users.message.toString(),Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, DashboardScreen::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Something went wrong, please try again later.",Toast.LENGTH_SHORT).show()
            }
        }


        binding.skipBtn.setOnClickListener(){
            val intent = Intent(this@MainActivity, DashboardScreen::class.java)
            startActivity(intent)
            finish()
        }

//        replaceFragment(OnBoardingFirstFragment())
        binding.signupOpt.setOnClickListener(){
            val intent = Intent(this@MainActivity, Signup::class.java)
            startActivity(intent)
            finish()
        }

        binding.forgotTxt.setOnClickListener(){
            val intent = Intent(this@MainActivity, ForgotPassword::class.java)
            startActivity(intent)
            finish()
        }

        emailFocusListener()
        passwordFocusListener()

        binding.loginBtn.setOnClickListener { submitForm() }

    }

    private fun submitForm() {
        Utils.showDialog(this)
        binding.textInputEmail.helperText = validEmail()
        binding.textInputPswd.helperText = validPassword()


        val validEmail = binding.textInputEmail.helperText == null
        val validPassword = binding.textInputPswd.helperText == null

        var name = binding.etEmail.text.toString()
        var email = binding.etPaswd.text.toString()


        if (validEmail && validPassword) {
            viewModel.apiCallForSignInUser(name,email)

            //pass main dashboard intent
         /*   var toast =
                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show()*/
//        else
//            invalidForm()
        }else{
            Utils.hideDialog()
        }
    }

//    private fun invalidForm()
//    {
//        var message = ""
//        if(binding.textInputEmail.helperText != null)
//            message += "\n\nEmail: " + binding.textInputEmail.helperText
//        if(binding.textInputPswd.helperText != null)
//            message += "\n\nPassword: " + binding.textInputPswd.helperText
//
//        AlertDialog.Builder(this)
//            .setTitle("Invalid Form")
//            .setMessage(message)
//            .setPositiveButton("Okay"){ _,_ ->
//                // do nothing
//            }
//            .show()
//    }

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
        if(emailText.isNullOrEmpty() && emailText.isNullOrBlank())
        {
            return "Please enter valid email/mobile"
        }
        return null
    }

    private fun passwordFocusListener()
    {
        binding.etPaswd.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.textInputPswd.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.etPaswd.text.toString()
        if(passwordText.isNullOrEmpty() && passwordText.isNullOrBlank())
        {
            return "Please enter valid password"
        }
        return null
    }


  /*  private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.tabContentContainer, fragment)
        transaction.commit()
    }*/
}