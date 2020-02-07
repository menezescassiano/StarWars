package com.cassiano.starwars.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cassiano.starwars.R

class RatingListAdapter(private val list: ArrayList<Boolean>) : RecyclerView.Adapter<RatingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        return RatingViewHolder(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), viewType, parent, false))
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        val item = list[position]

        holder.apply {
            bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_rating_item
    }
}