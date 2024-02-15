package com.unpadh.unpadhapp.onboarding_screens.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingFirstFragment
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingSecondFragment
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingThirdFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // Return the fragment for each page
        return when (position) {
            0 -> OnBoardingFirstFragment()
            1 -> OnBoardingSecondFragment()
            2 -> OnBoardingThirdFragment()
            // Add more cases for additional fragments if needed
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override fun getCount(): Int {
        // Return the number of pages
        return 3 // Adjust this based on the number of fragments you have
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Set the title for each tab
        return when (position) {
            0 -> "Tab 1"
            1 -> "Tab 2"
            2 -> "Tab 3"
            // Add more cases for additional tab titles if needed
            else -> null
        }
    }
}
