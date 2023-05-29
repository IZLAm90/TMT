package com.patient.tmt.presentation.fragment.consultation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentInstantConsultationBinding
import com.patient.tmt.databinding.FragmentSigenUpBinding

class InstantConsultationFragment : BaseFragment(R.layout.fragment_instant_consultation) {
    private lateinit var binding :FragmentInstantConsultationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInstantConsultationBinding.bind(view)
        binding.apply {
            consaltaion.setOnClickListener { findNavController().navigate(R.id.action_instantConsultationFragment_to_baymentFragment) }
        }
    }



}