package com.patient.tmt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patient.data.model.MedicalSecialtyModel
import com.patient.tmt.R
import com.patient.tmt.databinding.ItemMediaclSpecialtyBinding

class MedicalSpecialtiesAdapter : RecyclerView.Adapter<MedicalSpecialtiesAdapter.ViewHolder>(){
    private val list = ArrayList<MedicalSecialtyModel>()
    var OnItemSelected:((Int)->Unit) ?= null

    inner class ViewHolder(val binding: ItemMediaclSpecialtyBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data :MedicalSecialtyModel){
            binding.apply {
                imgSpecial.setImageResource(R.drawable.speciality_icon)
                titleSpecial.text=data.name
                root.setOnClickListener {
                    OnItemSelected?.invoke(adapterPosition)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMediaclSpecialtyBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
       return list.size
    }
    fun AddAll(data : List<MedicalSecialtyModel>){
        list.addAll(data)
    }
}