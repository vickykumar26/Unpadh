package com.unpadh.unpadhapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unpadh.unpadhapp.Item
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.name)
        val itemEmail: TextView = itemView.findViewById(R.id.email)
        val itemImage: CircleImageView = itemView.findViewById(R.id.circularImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemName.text = item.name
        holder.itemEmail.text = item.email
        holder.itemImage.setImageResource(item.image)
    }

    override fun getItemCount(): Int = items.size
}
