package com.examplelogin.bottom_nav

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter (private val exampleList: List<ExampleItem>) : RecyclerView.Adapter<RecyclerViewAdapter.Example>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Example {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return Example(itemView)
    }
    override fun onBindViewHolder(holder: Example, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
    }
    override fun getItemCount() = exampleList.size

    class Example(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.ivThumbnail
        val textView1: TextView = itemView.randomText
        val textView2: TextView = itemView.tvDescription
    }
}