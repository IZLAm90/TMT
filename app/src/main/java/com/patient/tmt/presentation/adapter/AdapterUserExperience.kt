package com.patient.tmt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patient.data.model.UserExperienceModel
import com.patient.tmt.databinding.ItemUserExperuenceBinding

class AdapterUserExperience : RecyclerView.Adapter<AdapterUserExperience.ViewHolder>() {
    private val list = ArrayList<UserExperienceModel>()

    inner class ViewHolder(val binding:ItemUserExperuenceBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(model: UserExperienceModel){
            binding.apply {
                userName.text=model.userName
                userFeedBack.text=model.userExperience
                docName.text=model.docName
                docSpeciality.text=model.docSpecialty
                rate.text=model.docRate
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserExperuenceBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
       return list.size
    }
    fun addAll(data : List<UserExperienceModel>){
        list.addAll(data)
    }
}