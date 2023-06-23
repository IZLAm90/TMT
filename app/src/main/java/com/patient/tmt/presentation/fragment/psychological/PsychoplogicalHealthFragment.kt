package com.patient.tmt.presentation.fragment.psychological

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
import com.patient.tmt.databinding.FragmentPsychoplogicalHealthBinding
import com.patient.tmt.presentation.adapter.AdapterUserExperience
import com.patient.tmt.presentation.adapter.DoctorsAdapter
import com.patient.tmt.presentation.fragment.specialties.SpecialitiesViewMode
import kotlinx.coroutines.launch

class PsychologicalHealthFragment : BaseFragment(R.layout.fragment_psychoplogical_health) {
    private lateinit var binding:FragmentPsychoplogicalHealthBinding
    private val viewModel by viewModels<SpecialitiesViewMode> ()
    private val adapter = DoctorsAdapter()
    private val adapterExcelledThisWeek = DoctorsAdapter()
    private val adapterRespondRithin6hours = DoctorsAdapter()
    private val adapterRespondRithin24hours = DoctorsAdapter()
    private val adapterUserExperience = AdapterUserExperience()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPsychoplogicalHealthBinding.bind(view)
        binding.apply {
            back.setOnClickListener {
                findNavController().navigateUp()
            }
            rvDoctors.setHasFixedSize(false)
            rvDoctors.adapter=adapter
            rvExcelledThisWeek.adapter=adapterExcelledThisWeek
            rvRespondRithin6hours.adapter=adapterRespondRithin6hours
            rvRespondRithin24hours.adapter=adapterRespondRithin24hours
            rvUserExperiences.adapter=adapterUserExperience
            lifecycleScope.launch {
                viewModel.doctorDataFlow.collect{
                    adapter.AddAll(it)
                    adapterExcelledThisWeek.AddAll(it)
                    adapterRespondRithin6hours.AddAll(it)
                    adapterRespondRithin24hours.AddAll(it)
                    Log.d("islam", "onViewCreated doctorDataFlow one  : ${it} ")
                }
            }
            lifecycleScope.launch {
                viewModel.userExperienceDataFlow.collect{
                    adapterUserExperience.addAll(it)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PsychologicalHealthFragment().apply {}
    }
}