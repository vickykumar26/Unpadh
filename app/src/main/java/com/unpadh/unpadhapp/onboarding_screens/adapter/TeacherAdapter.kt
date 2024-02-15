package com.unpadh.unpadhapp.onboarding_screens.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unpadh.unpadhapp.CourseItem
import com.unpadh.unpadhapp.R
import com.unpadh.unpadhapp.TeacherItem
import de.hdodenhof.circleimageview.CircleImageView

class TeacherAdapter (private val items: List<TeacherItem>) :
    RecyclerView.Adapter<TeacherAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.name)
        val itemSurname: TextView = itemView.findViewById(R.id.surname)
        val itemCircularImage: CircleImageView = itemView.findViewById(R.id.circularProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.teacher_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemName.text = item.name
        holder.itemSurname.text = item.surname
        holder.itemCircularImage.setImageResource(item.circularImage)
    }

    override fun getItemCount(): Int = items.size
}