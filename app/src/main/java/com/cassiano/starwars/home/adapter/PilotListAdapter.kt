package com.cassiano.starwars.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cassiano.starwars.R
import com.cassiano.starwars.databinding.LayoutPilotListItemBinding
import com.cassiano.starwars.home.model.PilotData

class PilotListAdapter(private val list: ArrayList<PilotData>) : RecyclerView.Adapter<PilotViewHolder>() {

    val selectedPilot: MutableLiveData<PilotData> = MutableLiveData()
    lateinit var binding: LayoutPilotListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PilotViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false) as LayoutPilotListItemBinding
        return PilotViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: PilotViewHolder, position: Int) {
        val item = list[position]

        item.pilot?.let {
            if (it.rating > 0.0) {
                setRecyclerView(it.getRatingList())
            }
        }

        holder.apply {
            bind(item)
            itemView.setOnClickListener {
                selectedPilot.value = item
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_pilot_list_item
    }

    private fun setRecyclerView(list: ArrayList<Boolean>) {
        val listAdapter = RatingListAdapter(list)
        binding.ratingRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}