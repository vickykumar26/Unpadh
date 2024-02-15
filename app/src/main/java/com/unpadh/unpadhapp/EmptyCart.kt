package com.unpadh.unpadhapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unpadh.unpadhapp.databinding.ActivityEmptyCartBinding
import com.unpadh.unpadhapp.fragments.HomeFragment

class EmptyCart : AppCompatActivity() {
    private lateinit var binding: ActivityEmptyCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmptyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowImg.setOnClickListener(){
            val intent = Intent(this@EmptyCart, HomeFragment::class.java)
            startActivity(intent)
            finish()
        }

        binding.shoppingBtn.setOnClickListener(){
            val intent = Intent(this@EmptyCart, HomeFragment::class.java)
            startActivity(intent)
            finish()
        }
    }
}