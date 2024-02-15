package com.unpadh.unpadhapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unpadh.unpadhapp.Item
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unpadh.unpadhapp.databinding.FragmentFollowingBinding
import com.unpadh.unpadhapp.databinding.FragmentSearchBinding

class FollowingFragment : Fragment() {

    private val items = ArrayList<Item>()
    private lateinit var binding: FragmentFollowingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFollowingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())



        items.add(Item("John Wick", "john.wick@email.com", R.drawable.profile_dash))
        items.add(Item("Robert J", "robert.j@email.com", R.drawable.profile_img))
        items.add(Item("Vicky Kumar", "vicky26@email.com", R.drawable.profile_dash))
        items.add(Item("Abhisek raj", "abhishek.r@email.com", R.drawable.profile_img))
        items.add(Item("Rudra", "rudra@email.com", R.drawable.profile_dash))
        items.add(Item("Amit kumar ", "Amit.k@email.com", R.drawable.profile_img))
        items.add(Item("Saurabh kumar", "saurabh.k@email.com", R.drawable.profile_dash))
        items.add(Item("Gaurav Suyal", "gaurav.s@email.com", R.drawable.profile_img))
        items.add(Item("Shubham verma", "Shubham.verma@email.com", R.drawable.profile_dash))


        recyclerView.adapter = RecyclerAdapter(items)

    }
}