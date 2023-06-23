package com.patient.tmt.presentation.fragment.specialties.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentDoctorDetailsBinding
import com.patient.tmt.presentation.adapter.AdapterUserExperience
import com.patient.tmt.presentation.fragment.specialties.SpecialitiesViewMode
import kotlinx.coroutines.launch


class DoctorDetailsFragment : BaseFragment(R.layout.fragment_doctor_details) {
    private lateinit var binding:FragmentDoctorDetailsBinding
    private val adapterUserExperience = AdapterUserExperience()
    private val viewModel by viewModels<SpecialitiesViewMode> ()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoctorDetailsBinding.bind(view)
        binding.apply {
            rvFeedBack.adapter=adapterUserExperience
        }
        lifecycleScope.launch {
            viewModel.userExperienceDataFlow.collect{
                adapterUserExperience.addAll(it)
            }
        }
    }

}