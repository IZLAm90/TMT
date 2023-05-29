package com.patient.tmt.presentation.fragment.specialties

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentMediaclSpecialtiesBinding


class MedicalSpecialtiesFragment : BaseFragment(R.layout.fragment_mediacl_specialties) {
   private lateinit var binding :FragmentMediaclSpecialtiesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMediaclSpecialtiesBinding.bind(view)
    }



}