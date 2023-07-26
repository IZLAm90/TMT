package com.patient.tmt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patient.data.model.HealthCareModel
import com.patient.tmt.databinding.ItemRelatedHealthBinding

class PsychologicalProgrammesAdapter :
    RecyclerView.Adapter<PsychologicalProgrammesAdapter.ViewHolder>() {
    private val data = ArrayList<HealthCareModel>()

    inner class ViewHolder(val binding: ItemRelatedHealthBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model :HealthCareModel){
            binding.apply {
                img.setImageResource(model.image)
                title.text=model.title
                description.text=model.description
                numberOfSets.text=model.numberOfSets
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRelatedHealthBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       data.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    fun AddAll(data : List<HealthCareModel>){
        this.data.addAll(data)
    }
}