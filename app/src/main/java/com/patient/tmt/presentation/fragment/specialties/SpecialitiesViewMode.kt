package com.patient.tmt.presentation.fragment.specialties

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patient.data.model.MedicalSecialtyModel
import com.patient.domain.MedicalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpecialitiesViewMode @Inject constructor(private val useCase: MedicalUseCase) : ViewModel(){
    private val _dataFlow = MutableSharedFlow<ArrayList<MedicalSecialtyModel>>()
    val dataFlow = _dataFlow.asSharedFlow()
    init {
        getMedicalData()
    }
    private  fun getMedicalData(){
        viewModelScope.launch {
        _dataFlow.emit(useCase.getMdedicalData())
        }
    }
}