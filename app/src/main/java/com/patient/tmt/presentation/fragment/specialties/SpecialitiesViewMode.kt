package com.patient.tmt.presentation.fragment.specialties

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patient.data.model.DoctorsModel
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
    private val _doctorDataFlow = MutableSharedFlow<ArrayList<DoctorsModel>>()
    val dataFlow = _dataFlow.asSharedFlow()
    val doctorDataFlow = _doctorDataFlow.asSharedFlow()
    init {
        getMedicalData()
        getDoctors()
    }
    private  fun getMedicalData(){
        viewModelScope.launch {
        _dataFlow.emit(useCase.getMdedicalData())
        }
    }

    private fun getDoctors(){
        viewModelScope.launch {
            _doctorDataFlow.emit(useCase.getDoctors())
        }
    }
}