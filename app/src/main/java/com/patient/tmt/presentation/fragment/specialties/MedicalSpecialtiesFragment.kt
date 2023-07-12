package com.patient.tmt.presentation.fragment.specialties

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentMediaclSpecialtiesBinding
import com.patient.tmt.presentation.adapter.MedicalSpecialtiesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MedicalSpecialtiesFragment : BaseFragment(R.layout.fragment_mediacl_specialties) {
   private lateinit var binding :FragmentMediaclSpecialtiesBinding
   private val adapter = MedicalSpecialtiesAdapter()
   private val viewModel by viewModels<SpecialitiesViewMode> ()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMediaclSpecialtiesBinding.bind(view)
        binding.apply {
            rvMedicalSpecialties.setHasFixedSize(false)
            rvMedicalSpecialties.adapter=adapter
            adapter.OnItemSelected={postion,name->
                val bundle = bundleOf("name" to name)
                findNavController().navigate(R.id.action_medicalSpecialtiesFragment_to_specificSpecialtiesFragment,bundle)
            }
            back.setOnClickListener{
                findNavController().navigateUp()
            }
        }
        lifecycleScope.launch {
            viewModel.dataFlow.collect {
                adapter.AddAll(it)
            }
        }

    }
}