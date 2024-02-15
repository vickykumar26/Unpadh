package com.unpadh.unpadhapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.unpadh.unpadhapp.databinding.ActivityDashboardScreenBinding
import com.unpadh.unpadhapp.fragments.AccountFragment
import com.unpadh.unpadhapp.fragments.HomeFragment
import com.unpadh.unpadhapp.fragments.MyLearningFragment
import com.unpadh.unpadhapp.fragments.SearchFragment
import com.unpadh.unpadhapp.fragments.WishlistFragment

class DashboardScreen : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityDashboardScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> openFragment(HomeFragment(),HomeFragment::class.java.name)

                R.id.nav_my_learning -> openFragment(MyLearningFragment())

                R.id.nav_wishlist -> openFragment(WishlistFragment())

                R.id.nav_account -> openFragment(AccountFragment())

                R.id.nav_search -> openFragment(SearchFragment())

            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment(), HomeFragment::class.java.name)

//        binding.searchFab.setOnClickListener(){
//                openFragment(SearchFragment())
//        }

    }

        private fun openFragment(fragment: Fragment, tag:String? = null){
            if (fragment is HomeFragment){
                supportFragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.addToBackStack(null).commit()
        }


    override fun onBackPressed() {
       if(supportFragmentManager.backStackEntryCount == 1){
           finish()
       }
        else{
            super.onBackPressed()
       }
    }

}