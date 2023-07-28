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
import com.patient.tmt.helper.nutritionProgrammesData
import com.patient.tmt.helper.searchDataCommon
import com.patient.tmt.helper.searchDataIssue
import com.patient.tmt.helper.userExperienceDate
import com.patient.tmt.presentation.adapter.*
import com.patient.tmt.presentation.fragment.specialties.SpecialitiesViewMode
import kotlinx.coroutines.launch

class PsychologicalHealthFragment : BaseFragment(R.layout.fragment_psychoplogical_health) {
    private lateinit var binding:FragmentPsychoplogicalHealthBinding
    private val viewModel by viewModels<SpecialitiesViewMode> ()
    private val adapter = PsychologicalHealthAdapter()
    private val adapterExcelledThisWeek = PsychologicalHealthAdapter()
    private val adapterRespondRithin6hours = PsychologicalHealthAdapter()
    private val adapterRespondRithin24hours = PsychologicalHealthAdapter()
    private val adapterUserExperience = AdapterUserExperience()
    private val adapterRelatedHealthyCare = PsychologicalProgrammesAdapter()
    private val adapterFilters = FilterAdapter()
    private val adapterFiltersCommon = FilterAdapter()
    private val adapterDocGeneric = DoctorPsyWithDesc()
    private val adapterDocFamily= DoctorPsyWithDesc()
    private val adapterDocCare= DoctorPsyWithDesc()
    private val adapterDocOlder= DoctorPsyWithDesc()

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
            rvRelatedHealthCareProgrammes.adapter=adapterRelatedHealthyCare
            rvCommonHealthComplaints.adapter=adapterFilters
            rvCommonDiseases.adapter=adapterFiltersCommon
            rvDocCare.adapter=adapterDocCare
            rvDocFamily.adapter=adapterDocFamily
            rvDocGeneric.adapter=adapterDocGeneric
            rvDocOlder.adapter=adapterDocOlder
            adapter.OnItemSelected={i->
                findNavController().navigate(R.id.action_psychologicalHealthFragment_to_doctorDetailsFragment)
            }
            adapterExcelledThisWeek.OnItemSelected={i->
                findNavController().navigate(R.id.action_psychologicalHealthFragment_to_doctorDetailsFragment)
            }
            adapterRespondRithin6hours.OnItemSelected={i->
                findNavController().navigate(R.id.action_psychologicalHealthFragment_to_doctorDetailsFragment)
            }
            adapterRespondRithin24hours.OnItemSelected={i->
                findNavController().navigate(R.id.action_psychologicalHealthFragment_to_doctorDetailsFragment)
            }

            lifecycleScope.launch {
                viewModel.doctorDataFlow.collect{
                    adapter.AddAll(it)
                    adapterDocCare.AddAll(it)
                    adapterDocFamily.AddAll(it)
                    adapterDocGeneric.AddAll(it)
                    adapterDocOlder.AddAll(it)
                    adapterExcelledThisWeek.AddAll(it)
                    adapterRespondRithin6hours.AddAll(it)
                    adapterRespondRithin24hours.AddAll(it)
                }
            }
            adapterRelatedHealthyCare.AddAll(nutritionProgrammesData())
            adapterFilters.addAll(searchDataIssue())
            adapterFiltersCommon.addAll(searchDataCommon())
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