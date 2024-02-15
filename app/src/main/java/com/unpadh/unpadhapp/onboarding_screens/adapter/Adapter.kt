package com.unpadh.unpadhapp.onboarding_screens.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingFirstFragment
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingSecondFragment
import com.unpadh.unpadhapp.onboarding_screens.OnBoardingThirdFragment

class Adapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return OnBoardingFirstFragment()
            }
            1 -> {
                return OnBoardingSecondFragment()
            }
            2 -> {
                return OnBoardingThirdFragment()
            }
            else -> {
                return OnBoardingFirstFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }
            2 -> {
                return "Tab 3"
            }
        }
        return super.getPageTitle(position)
       }
}