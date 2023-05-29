package com.patient.tmt.presentation.fragment.specialties.specificspecialities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentSpecificSpecialtiesBinding


class SpecificSpecialtiesFragment : BaseFragment(R.layout.fragment_specific_specialties) {
    private lateinit var binding : FragmentSpecificSpecialtiesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSpecificSpecialtiesBinding.bind(view)
    }


}