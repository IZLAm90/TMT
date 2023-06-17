package com.patient.tmt.presentation.fragment.healthycare

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patient.data.model.HealthCareModel
import com.patient.data.model.MedicalSecialtyModel
import com.patient.domain.medicalcare.MedicalCareUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HealthyCareViewModel@Inject constructor(private val useCase: MedicalCareUseCase) : ViewModel() {
    private val _dataFlow = MutableSharedFlow<ArrayList<HealthCareModel>>()
    val dataFlow = _dataFlow.asSharedFlow()
         fun getPsychologicalProgrammes(list: ArrayList<HealthCareModel>) {
            viewModelScope.launch {
                _dataFlow.emit(useCase.getPsychologicalProgrammes(list))
            }
        }

}