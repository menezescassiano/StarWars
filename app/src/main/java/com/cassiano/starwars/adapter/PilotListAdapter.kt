package com.cassiano.starwars.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cassiano.starwars.R
import com.cassiano.starwars.model.PilotData

class PilotListAdapter(private val list: ArrayList<PilotData>) : RecyclerView.Adapter<PilotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PilotViewHolder {
       return PilotViewHolder(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: PilotViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_pilot_list_item
    }
}