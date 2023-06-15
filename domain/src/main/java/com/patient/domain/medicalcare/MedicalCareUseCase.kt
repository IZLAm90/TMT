package com.patient.domain.medicalcare

import com.patient.data.model.HealthCareModel
import com.patient.data.repository.medicalcare.MedicalCareRepo
import com.patient.data.repository.medicalrepo.MedicalSpecialtyRepo
import javax.inject.Inject

class MedicalCareUseCase@Inject constructor(private val repo: MedicalCareRepo) {
    suspend fun getPsychologicalProgrammes(list: ArrayList<HealthCareModel>)=repo.getPsychologicalProgrammes(list)
}