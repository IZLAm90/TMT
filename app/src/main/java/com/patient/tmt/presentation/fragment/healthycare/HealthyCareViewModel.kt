package com.patient.tmt.presentation.fragment.healthycare

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patient.data.model.HealthCareModel
import com.patient.domain.MedicalUseCase
import com.patient.domain.medicalcare.MedicalCareUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HealthyCareViewModel@Inject constructor(private val useCase: MedicalCareUseCase) : ViewModel() {

        private fun getPsychologicalProgrammes() {
            viewModelScope.launch {
//            useCase.getPsychologicalProgrammes(emptyArray<HealthCareModel>())
            }
        }

}