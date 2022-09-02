package com.stone.mvpxml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stone.mvpxml.inerfaces.Posts

class MyAdapters(): RecyclerView.Adapter<MyAdapters.MyViewHolder>() {
    var allusers:List<Posts>? = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentuser = allusers!![position]
        holder.recname.text = currentuser.id.toString()
        holder.recaddress.text = currentuser.title
        holder.recmail.text = currentuser.body
    }
    override fun getItemCount(): Int {
        return allusers!!.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recname: TextView = itemView.findViewById(R.id.recyclername)
        var recaddress: TextView = itemView.findViewById(R.id.recycleraddress)
        var recmail: TextView = itemView.findViewById(R.id.recyclermail)
    }
    fun setdata(data: List<Posts>) {
        this.allusers=data
        notifyDataSetChanged()
    }
}