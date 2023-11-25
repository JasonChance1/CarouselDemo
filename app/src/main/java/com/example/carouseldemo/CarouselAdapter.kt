package com.example.carouseldemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

/**
 * @description:
 * @author yanglei
 * @date :2023/11/24
 * @version 1.0.0
 */
class CarouselAdapter(private val context: Context, private val icons:List<Int>) : RecyclerView.Adapter<CarouselAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.carousel_image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_carousel,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(icons[position])
    }

    override fun getItemCount(): Int {
        return icons.size
    }

}