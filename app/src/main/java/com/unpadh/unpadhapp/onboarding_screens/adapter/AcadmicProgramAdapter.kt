package com.unpadh.unpadhapp.onboarding_screens.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unpadh.unpadhapp.AcadmicProgramItem
import com.unpadh.unpadhapp.CourseRecyclerAdapter
import com.unpadh.unpadhapp.CoursesItem
import com.unpadh.unpadhapp.R

class AcadmicProgramAdapter(private val items: List<AcadmicProgramItem>) :
    RecyclerView.Adapter<AcadmicProgramAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemAcadmicName: TextView = itemView.findViewById(R.id.accadmic_name)
        val itemAccadmicImg: ImageView = itemView.findViewById(R.id.accadmic_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_program_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemAcadmicName.text = item.accadmicName
        holder.itemAccadmicImg.setImageResource(item.accadmicImg)
    }

    override fun getItemCount(): Int = items.size
}