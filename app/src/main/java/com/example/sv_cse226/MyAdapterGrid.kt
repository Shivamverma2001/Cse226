package com.example.sv_cse226

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapterGrid (var c: Context,var list:ArrayList<GridModel>)
    : RecyclerView.Adapter<MyAdapterGrid.MyHolder>()
{
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var name:TextView
        var image:ImageView
        init{
            name=itemView.findViewById(R.id.name)
            image=itemView.findViewById(R.id.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var v:View=LayoutInflater.from(c).inflate(R.layout.grid_layout,parent,false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.text=list[position].name
        holder.image.setImageResource(list[position].image)
    }
}