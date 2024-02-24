package com.unpadh.unpadhapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unpadh.unpadhapp.databinding.ActivityCheckEmailBinding
import android.content.ComponentName
import android.util.Log
import androidx.databinding.Observable
import com.unpadh.unpadhapp.api.UserViewModel
import com.unpadh.unpadhapp.api.repository.UserRepository

class CheckEmail : AppCompatActivity() {

    private lateinit var binding: ActivityCheckEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.laterBtn.setOnClickListener(){

            val intent =  Intent(this@CheckEmail, ResetPassword::class.java)
            startActivity(intent)
            finish()
        }

        binding.checkEmailBtn.setOnClickListener(){
                openGmailApp()
        }

    }

    private fun openGmailApp() {
        val packageName = "com.google.android.gm"

        // Check if Gmail app is installed
        if (isAppInstalled(packageName)) {
            // If installed, create an intent to launch the Gmail app
            val intent = Intent(Intent.ACTION_MAIN)
            intent.component = ComponentName(packageName, "com.google.android.gm.ConversationListActivityGmail")
            startActivity(intent)
        } else {
            // If not installed, you can take appropriate action, such as opening the Gmail website
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com"))
            startActivity(webIntent)
        }
    }

    private fun isAppInstalled(packageName: String): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }


}
