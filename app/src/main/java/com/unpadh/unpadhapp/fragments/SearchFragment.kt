package com.unpadh.unpadhapp.fragments

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unpadh.unpadhapp.R
import com.unpadh.unpadhapp.databinding.FragmentHomeBinding
import com.unpadh.unpadhapp.databinding.FragmentSearchBinding
import com.unpadh.unpadhapp.onboarding_screens.adapter.AllCoursesAdapter

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.allCategory,
            R.layout.drop_down_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.drop_down_item)
            binding.spinner.adapter = adapter
        }

        // Set click listener for the layout to open the spinner
        binding.spLayout.setOnClickListener {
            binding.spinner.performClick()
        }

        // Set item selected listener for the spinner
        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                requireContext().getColor(R.color.black)?.let {
                    if (p1 is TextView) {
                        p1.setTextColor(it)
                        p1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
                    }
                }
                p0?.getItemAtPosition(p2).let {
                    binding.spLayout.text = it.toString()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Handle nothing selected if needed
            }
        }


        val adaptor = AllCoursesAdapter(searchData())
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
        binding.recyclerView.adapter = adaptor

        return binding.root
    }

    private fun fetchData(): ArrayList<String> {
        val item = ArrayList<String>()

        item.add("Photography")
        item.add("Craft")
        item.add("art")
        item.add("Marketing")
        item.add("Procreate")

        return item
    }

    private fun searchData(): ArrayList<String> {
        val item = ArrayList<String>()

        item.add("Photography")
        item.add("Craft")
        item.add("art")
        item.add("Marketing")
        item.add("Procreate")

        return item
    }

}