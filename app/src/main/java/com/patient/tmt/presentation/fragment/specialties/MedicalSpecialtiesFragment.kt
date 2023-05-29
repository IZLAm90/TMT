package com.patient.tmt.presentation.fragment.specialties

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentMediaclSpecialtiesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MedicalSpecialtiesFragment : BaseFragment(R.layout.fragment_mediacl_specialties) {
   private lateinit var binding :FragmentMediaclSpecialtiesBinding
//   private val viewModel by activityViewModels<SpecialitiesViewMode> ()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMediaclSpecialtiesBinding.bind(view)
//        Log.d("islam", "onViewCreated test one  : ${viewModel.dataFlow} ")
    }
}