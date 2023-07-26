package com.patient.tmt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patient.tmt.databinding.ItemFilterBinding

class FilterAdapter: RecyclerView.Adapter<FilterAdapter.ViewHolder>() {
    private val list = ArrayList<String>()

    inner class ViewHolder(val binding: ItemFilterBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(model: String){
            binding.apply {
                filterName.text=model
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFilterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun addAll(data : List<String>){
        list.addAll(data)
    }
}