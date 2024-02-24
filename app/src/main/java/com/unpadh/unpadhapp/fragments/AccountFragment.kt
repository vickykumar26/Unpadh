package com.unpadh.unpadhapp.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unpadh.unpadhapp.R
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.unpadh.unpadhapp.CoursesFragment
import com.unpadh.unpadhapp.EmptyCart
import com.unpadh.unpadhapp.FollowingFragment
import com.unpadh.unpadhapp.FragmentAdapter
import com.unpadh.unpadhapp.ProjectFragment
import com.unpadh.unpadhapp.SettingScreen
import com.unpadh.unpadhapp.databinding.FragmentAccountBinding
import com.unpadh.unpadhapp.databinding.FragmentHomeBinding
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesDataSource
import com.unpadh.unpadhapp.shared_preference.SharedPreferencesRepository
import com.unpadh.unpadhapp.utils.AppConstants

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding

    private lateinit var sharedPreferencesRepository: SharedPreferencesDataSource


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.root.findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = binding.root.findViewById<TabLayout>(R.id.tablayout)

        val fragmentAdapter = FragmentAdapter(childFragmentManager) // Use childFragmentManager for fragments inside a Fragment
//        fragmentAdapter.addFragment(ProjectFragment(), "Project")
        fragmentAdapter.addFragment(CoursesFragment(), "Courses")
        fragmentAdapter.addFragment(FollowingFragment(), "Following")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

        binding.settingBtn.setOnClickListener(){

            val intent = Intent(requireContext(), SettingScreen::class.java)
            startActivity(intent)
        }

        sharedPreferencesRepository = SharedPreferencesRepository(requireContext())

        var profileImg = sharedPreferencesRepository.getStringValue(AppConstants.USER_PROFILE_PIC, "")
        var userName = sharedPreferencesRepository.getStringValue(AppConstants.USER_NAME, "")

        binding.profileName.setText("${userName.toString()}")
        if (!profileImg.isNullOrEmpty()){
            binding.profileImage.setImageBitmap(base64ToBitmap(profileImg))
        }
    }


    private fun base64ToBitmap(base64String: String?): Bitmap? {
        try {
            if (base64String != null) {
                val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
                return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

}