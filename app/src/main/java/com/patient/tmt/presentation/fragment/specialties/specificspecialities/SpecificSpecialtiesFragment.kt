package com.patient.tmt.presentation.fragment.specialties.specificspecialities

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentSpecificSpecialtiesBinding
import com.patient.tmt.presentation.adapter.DoctorsAdapter
import com.patient.tmt.presentation.adapter.MedicalSpecialtiesAdapter
import com.patient.tmt.presentation.fragment.specialties.SpecialitiesViewMode
import kotlinx.coroutines.launch


class SpecificSpecialtiesFragment : BaseFragment(R.layout.fragment_specific_specialties) {
    private lateinit var binding : FragmentSpecificSpecialtiesBinding
    private val adapter = DoctorsAdapter()
    private val viewModel by viewModels<SpecialitiesViewMode> ()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSpecificSpecialtiesBinding.bind(view)
        binding.apply {
            back.setOnClickListener {
                findNavController().navigateUp()
            }
            rvDoctors.setHasFixedSize(false)
            rvDoctors.adapter=adapter
            lifecycleScope.launch {
                viewModel.doctorDataFlow.collect{
                    adapter.AddAll(it)
                    Log.d("islam", "onViewCreated doctorDataFlow one  : ${it} ")
                }
            }
        }
    }


}