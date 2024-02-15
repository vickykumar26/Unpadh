package com.unpadh.unpadhapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CourseRecyclerAdapter(private val items: List<CoursesItem>) :
    RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemCourseName: TextView = itemView.findViewById(R.id.courseName)
        val itemTeacherName: TextView = itemView.findViewById(R.id.teacherName)
        val itemCountStundent: TextView = itemView.findViewById(R.id.countStudent)
        val itemCourseRating: TextView = itemView.findViewById(R.id.courseRating)
        val itemCourseImage: ImageView = itemView.findViewById(R.id.courseImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.courses_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemCourseName.text = item.courseName
        holder.itemTeacherName.text = item.teacherName
        holder.itemCountStundent.text = item.countStudent
        holder.itemCourseRating.text = item.courseRating
        holder.itemCourseImage.setImageResource(item.courseImageView)
    }

    override fun getItemCount(): Int = items.size
}
