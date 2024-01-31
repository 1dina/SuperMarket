package com.example.supermarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuperMarketAdapter : RecyclerView.Adapter<SuperMarketAdapter.ViewHolder>() {
    var adapterArrayList :List<SuperMarketModel> = ArrayList()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.findViewById<TextView>(R.id.itemName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.supermarket_item_view,parent,false))

    }
     fun setArray(arrayList: List<SuperMarketModel>){
        adapterArrayList=arrayList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return adapterArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.textView.setText(adapterArrayList.get(position).text)

    }

}