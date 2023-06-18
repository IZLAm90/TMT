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
    private val _dataFlowHealthCare = MutableSharedFlow<ArrayList<HealthCareModel>>()
    private val _dataFlowFamilyLifeProgrammes = MutableSharedFlow<ArrayList<HealthCareModel>>()
    val dataFlowHealthCare = _dataFlowHealthCare.asSharedFlow()
    val dataFlowFamily = _dataFlowFamilyLifeProgrammes.asSharedFlow()
         fun getPsychologicalProgrammes(list: ArrayList<HealthCareModel>) {
            viewModelScope.launch {
                _dataFlowHealthCare.emit(useCase.getPsychologicalProgrammes(list))
            }
        }
    fun FamilyLifeProgrammes(list: ArrayList<HealthCareModel>) {
            viewModelScope.launch {
                _dataFlowFamilyLifeProgrammes.emit(useCase.FamilyLifeProgrammes(list))
            }
        }

}