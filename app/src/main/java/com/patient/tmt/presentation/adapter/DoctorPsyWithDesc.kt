package com.patient.tmt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patient.data.model.DoctorsModel
import com.patient.tmt.databinding.ItemDoctorRateBinding

class DoctorPsyWithDesc :RecyclerView.Adapter<DoctorPsyWithDesc.ViewHolder>() {
    private val data = ArrayList<DoctorsModel>()

    inner class ViewHolder(val binding: ItemDoctorRateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model : DoctorsModel){
            binding.apply {
//                docImg.setImageResource(model.docImg)
                docName.text=model.docName
                docSpeciality.text=model.docSpecialty
                decription.text=model.rate
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDoctorRateBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    fun AddAll(data : List<DoctorsModel>){
        this.data.addAll(data)
    }
}