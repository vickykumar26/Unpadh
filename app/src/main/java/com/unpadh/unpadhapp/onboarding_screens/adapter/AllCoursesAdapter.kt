package com.unpadh.unpadhapp.onboarding_screens.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.unpadh.unpadhapp.R

class AllCoursesAdapter (private val item: ArrayList<String>) : RecyclerView.Adapter<AllCoursesAdapter.ViewHolder>() {
    private val selectedItems = HashSet<Int>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.all_courses_item, parent, false))
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = item[position]
        holder.textView.text = currentItem

        // Set the background shape based on the selection state
        val isSelected = selectedItems.contains(position)
        if (isSelected) {
            holder.textView.setTextColor(Color.WHITE)
            holder.textView.setBackgroundResource(R.drawable.all_courses_background_selected)
        } else {
            holder.textView.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            holder.textView.setBackgroundResource(R.drawable.all_courses_background)
        }

        holder.itemView.setOnClickListener {
            toggleItemSelection(position)
        }
    }

    private fun toggleItemSelection(position: Int) {
        if (selectedItems.contains(position)) {
            selectedItems.remove(position)
        } else {
            selectedItems.add(position)
        }
        notifyItemChanged(position)
    }
}
