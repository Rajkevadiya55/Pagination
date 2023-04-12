package com.example.pagination.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pagination.Model.PhotosItem
import com.example.pagination.R

class WallpapersAdapter(list: ArrayList<PhotosItem>) :RecyclerView.Adapter<WallpapersAdapter.WallpaperHolder>(){
  var list=list
    lateinit var context:Context
    class WallpaperHolder(itemView: View): ViewHolder(itemView) {
  var img=itemView.findViewById<ImageView>(R.id.imgEffect)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
        context=parent.context
        var view =LayoutInflater.from(parent.context).inflate(R.layout.efect_item,parent,false)
        return WallpaperHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WallpaperHolder, position: Int) {
        Glide.with(context).load(list.get(position).src?.portrait).into(holder.img)
    }
}