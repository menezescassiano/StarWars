package com.cassiano.starwars.home.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cassiano.starwars.BR
import com.cassiano.starwars.home.model.PilotData
import com.cassiano.starwars.utils.DrawableUtils

class PilotViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PilotData) {

        this.binding.apply {
            val context = this.root.context
            item.run {
                setVariable(BR.name, pilot?.name)
                setVariable(BR.pickUp, pickUp?.name)
                setVariable(BR.dropOff, dropOff?.name)
                setVariable(BR.picture, pilot?.name?.let { DrawableUtils.getAvatar(context, it) })
            }
            executePendingBindings()
        }
    }
}