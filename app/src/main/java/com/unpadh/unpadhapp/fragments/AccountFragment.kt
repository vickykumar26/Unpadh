package com.unpadh.unpadhapp.fragments

import android.content.Intent
import android.os.Bundle
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

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding


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

    }

}