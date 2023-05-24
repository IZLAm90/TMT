package com.patient.tmt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patient.data.model.ModelMainViewPager
import com.patient.tmt.databinding.ItemMainViewPagerBinding

class MainViewPageAdapter : RecyclerView.Adapter<MainViewPageAdapter.ViewHolder>() {
    private val list = ArrayList<ModelMainViewPager?>()

    inner class ViewHolder(val binding : ItemMainViewPagerBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data :ModelMainViewPager){
            binding?.apply {
                imgViewPage.setImageResource(data.img)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMainViewPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
     return  list.size
    }

    fun AddAll(data : List<ModelMainViewPager>){
        list.addAll(data)
    }
}