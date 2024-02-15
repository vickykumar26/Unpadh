package com.unpadh.unpadhapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unpadh.unpadhapp.databinding.FragmentCoursesBinding



class CoursesFragment : Fragment() {

    private val items = ArrayList<CoursesItem>()
    private lateinit var binding: FragmentCoursesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoursesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val coursesRecyclerView: RecyclerView = binding.coursesRecyclerView
        coursesRecyclerView.layoutManager = LinearLayoutManager(requireContext())



        items.add(CoursesItem("Adobe illustrator for all beginner artist", "Samule Doe","4k Stundent","4.7", R.drawable.course_adobe))
        items.add(CoursesItem("Digital illustration technique for procrete", "Sarrah Morry","2k Stundent","4.0", R.drawable.course_digital))
        items.add(CoursesItem("Learn how to draw cartoon face in easy way!", "Samule Doe","3k Stundent","3.7", R.drawable.course_draw_cartoon))
        items.add(CoursesItem("Sketch book essential for everyone!", "Sarrah Morry","3.5k Stundent","4.2", R.drawable.course_sketch))
        items.add(CoursesItem("Adobe illustrator for all beginner artist", "Samule Doe","4k Stundent","3.9", R.drawable.course_adobe))
        items.add(CoursesItem("Learn how to draw cartoon face in easy way!", "Sarrah Morry","4.5k Stundent","4.8", R.drawable.course_draw_cartoon))
        items.add(CoursesItem("Digital illustration technique for procrete", "Samule Doe","6k Stundent","4.3", R.drawable.course_digital))
        items.add(CoursesItem("Sketch book essential for everyone!", "Sarrah Morry","1.5k Stundent","5.0", R.drawable.course_sketch))



        coursesRecyclerView.adapter = CourseRecyclerAdapter(items)

    }
}