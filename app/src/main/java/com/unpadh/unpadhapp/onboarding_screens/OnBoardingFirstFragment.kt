package com.unpadh.unpadhapp.onboarding_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.unpadh.unpadhapp.R


class OnBoardingFirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_boarding_first, container, false)

       view.findViewById<TextView>(R.id.onbardingbtn1).setOnClickListener {
            // Get the ViewPager from the parent activity and move to the next fragment
            (activity as? OnBoardingScreensActivity)?.moveToNextFragment()
        }


        return view
    }

}