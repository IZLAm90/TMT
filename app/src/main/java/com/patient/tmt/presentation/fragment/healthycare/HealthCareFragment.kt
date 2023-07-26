package com.patient.tmt.presentation.fragment.healthycare

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.data.model.HealthCareModel
import com.patient.data.model.UserExperienceModel
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentHealthCareBinding
import com.patient.tmt.helper.*
import com.patient.tmt.presentation.adapter.AdapterUserExperience
import com.patient.tmt.presentation.adapter.PsychologicalProgrammesAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HealthCareFragment : BaseFragment(R.layout.fragment_health_care) {
    private val viewModel by viewModels<HealthyCareViewModel>()
    private val adapterPsychological = PsychologicalProgrammesAdapter()
    private val adapterFamilyLifeProgrammes = PsychologicalProgrammesAdapter()
    private val adapterSelfDevelopmentProgrammes = PsychologicalProgrammesAdapter()
    private val adapterKidsPrograms = PsychologicalProgrammesAdapter()
    private val adapterNutritionProgrammes = PsychologicalProgrammesAdapter()
    private val adapterMedicalPrograms = PsychologicalProgrammesAdapter()
    private val adapterUserExperience = AdapterUserExperience()
    private lateinit var binding: FragmentHealthCareBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHealthCareBinding.bind(view)
        setUpRvs()

    }

    fun setUpRvs() {
        getHealthy()
        getUserExperiance()
        binding.apply {
            rvPsychologicalProgrammes.adapter = adapterPsychological
            rvFamilyLifeProgrammes.adapter = adapterFamilyLifeProgrammes
            rvSelfDevelopmentProgrammes.adapter = adapterSelfDevelopmentProgrammes
            rvKidsPrograms.adapter = adapterKidsPrograms
            rvNutritionProgrammes.adapter = adapterNutritionProgrammes
            rvMedicalPrograms.adapter = adapterMedicalPrograms
            rvMe.adapter=adapterUserExperience
            adapterPsychological.AddAll(getHealthy())
            adapterFamilyLifeProgrammes.AddAll(familyLifeProgrammesData())
            adapterSelfDevelopmentProgrammes.AddAll(selfDevelopmentData())
            adapterKidsPrograms.AddAll(kidsData())
            adapterNutritionProgrammes.AddAll(nutritionProgrammesData())
            adapterMedicalPrograms.AddAll(MedicalProgramsData())
            adapterUserExperience.addAll(userExperienceDate())

            back.setOnClickListener {
                findNavController().navigateUp()
            }
        }
        viewModel.getUserExperiance(getUserExperiance())
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dataFlowUserExperience.collectLatest {
                adapterUserExperience.addAll(it)
            }
        }
    }



}