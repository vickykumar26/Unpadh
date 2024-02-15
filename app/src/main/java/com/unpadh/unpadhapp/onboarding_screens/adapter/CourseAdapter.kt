package com.unpadh.unpadhapp.onboarding_screens.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unpadh.unpadhapp.CourseItem
import com.unpadh.unpadhapp.R

class CourseAdapter(private val items: List<CourseItem>) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemCourseName: TextView = itemView.findViewById(R.id.courseName)
        val itemCourseTeacher: TextView = itemView.findViewById(R.id.courseTeacher)
        val itemRating: TextView = itemView.findViewById(R.id.rating)
        val itemRatingCount: TextView = itemView.findViewById(R.id.ratingCount)
        val itemFeeText: TextView = itemView.findViewById(R.id.feeText)
        val itemCourseImg: ImageView = itemView.findViewById(R.id.courseImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemCourseName.text = item.courseName
        holder.itemCourseTeacher.text = item.courseTeacher
        holder.itemRating.text = item.rating
        holder.itemRatingCount.text = item.ratingCount
        holder.itemFeeText.text = item.feeText
        holder.itemCourseImg.setImageResource(item.courseImage)
    }

    override fun getItemCount(): Int = items.size
}