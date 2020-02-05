package com.cassiano.starwars.home.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cassiano.starwars.BR
import com.cassiano.starwars.home.model.PilotData
import com.cassiano.starwars.utils.DrawableUtils

class PilotViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PilotData) {

        binding.apply {
            val context = this.root.context
            val rating = item.pilot?.rating
            item.run {
                setVariable(BR.name, pilot?.name)
                setVariable(BR.pickUp, pickUp?.name)
                setVariable(BR.dropOff, dropOff?.name)
                setVariable(BR.picture, pilot?.name?.let { DrawableUtils.getAvatar(context, it) })
                setVariable(BR.star1, rating?.let { DrawableUtils.getStarRating(context, 1, it) })
                setVariable(BR.star2, rating?.let { DrawableUtils.getStarRating(context, 2, it) })
                setVariable(BR.star3, rating?.let { DrawableUtils.getStarRating(context, 3, it) })
                setVariable(BR.star4, rating?.let { DrawableUtils.getStarRating(context, 4, it) })
                setVariable(BR.star5, rating?.let { DrawableUtils.getStarRating(context, 5, it) })
            }
            executePendingBindings()
        }
    }
}