package com.unpadh.unpadhapp.onboarding_screens.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.unpadh.unpadhapp.R



class SliderAdapter(imageResourceIds: ArrayList<Int>) : SliderViewAdapter<SliderAdapter.SliderViewHolder>() {
    private var sliderImageResourceIds: ArrayList<Int> = imageResourceIds

    override fun getCount(): Int {
        return sliderImageResourceIds.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val inflater: View = LayoutInflater.from(parent!!.context).inflate(R.layout.slideritem, null)
        return SliderViewHolder(inflater)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapter.SliderViewHolder?, position: Int) {
        if (viewHolder != null)
            Glide.with(viewHolder.itemView).load(sliderImageResourceIds[position]).fitCenter().into(viewHolder.imageView)
    }

    class SliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById<ImageView>(R.id.myImage)
    }
}