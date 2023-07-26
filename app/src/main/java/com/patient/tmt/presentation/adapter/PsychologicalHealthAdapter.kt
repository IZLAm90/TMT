package com.patient.tmt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patient.data.model.DoctorsModel
import com.patient.tmt.R
import com.patient.tmt.databinding.ItemPsychologicalHealthDoctorsBinding

class PsychologicalHealthAdapter : RecyclerView.Adapter<PsychologicalHealthAdapter.ViewHolder>() {
    private val list = ArrayList<DoctorsModel>()
    var OnItemSelected:((Int)->Unit) ?= null

    inner class ViewHolder(val binding: ItemPsychologicalHealthDoctorsBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(data : DoctorsModel){
            binding.apply {
                docImg.setImageResource(R.drawable.speciality_icon)
                docName.text=data.docName
                docSpeciality.text=data.docSpecialty
                root.setOnClickListener {
                    OnItemSelected?.invoke(adapterPosition)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPsychologicalHealthDoctorsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun AddAll(data : List<DoctorsModel>){
        list.addAll(data)
    }
}