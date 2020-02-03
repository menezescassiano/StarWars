package com.cassiano.starwars.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cassiano.starwars.BR
import com.cassiano.starwars.model.PilotData

class PilotViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PilotData) {

        binding.apply {
            val context = this.root.context

            item.run {
                setVariable(BR.text, pilot?.name)
                /*setVariable(BR.icon, type?.let { getDrawable(it, context) })*/
            }
            executePendingBindings()
        }
    }
}