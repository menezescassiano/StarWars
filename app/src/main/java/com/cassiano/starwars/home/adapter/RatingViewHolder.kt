package com.cassiano.starwars.home.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cassiano.starwars.BR
import com.cassiano.starwars.utils.DrawableUtils

class RatingViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Boolean) {
        binding.apply {
            val context = this.root.context
            setVariable(BR.star, DrawableUtils.getStarRatingList(context, item))
            executePendingBindings()
        }
    }
}