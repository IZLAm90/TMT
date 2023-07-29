package com.patient.tmt.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.patient.tmt.databinding.ItemReceiverSmsBinding
import com.patient.tmt.databinding.ItemSenderSmsBinding

class AdapterSms : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val smsList = ArrayList<Any?>()
    private val SENDER = 1
    private val RECIVER = 2

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    inner class SenderViewHolder(private val binding :ItemSenderSmsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:String){
            binding.tvMessage.text=item
        }
    }
    inner class ReciverViewHolder(private val binding:ItemReceiverSmsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: String){
            binding.tvMessage.text=item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return when(viewType){
        SENDER->{
            val binding = ItemSenderSmsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            SenderViewHolder(binding)
        }
        RECIVER->{
            val binding = ItemReceiverSmsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            ReciverViewHolder(binding)
        }
        else -> throw IllegalArgumentException("Invalid view type")
    }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is SenderViewHolder->{
                val item=smsList[position] as String
                holder.bind(item)
            }
            is ReciverViewHolder->{
                val item=smsList[position] as String
                holder.bind(item)
            }

        }
    }

    override fun getItemCount(): Int =smsList.size


}