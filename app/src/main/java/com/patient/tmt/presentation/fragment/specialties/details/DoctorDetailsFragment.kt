package com.patient.tmt.presentation.fragment.specialties.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentDoctorDetailsBinding


class DoctorDetailsFragment : BaseFragment(R.layout.fragment_doctor_details) {
    private lateinit var binding:FragmentDoctorDetailsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoctorDetailsBinding.bind(view)
    }

}