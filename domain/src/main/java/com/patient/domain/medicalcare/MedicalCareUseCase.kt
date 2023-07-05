package com.patient.domain.medicalcare

import com.patient.data.model.HealthCareModel
import com.patient.data.model.UserExperienceModel
import com.patient.data.repository.medicalcare.MedicalCareRepo
import com.patient.data.repository.medicalrepo.MedicalSpecialtyRepo
import javax.inject.Inject

class MedicalCareUseCase@Inject constructor(private val repo: MedicalCareRepo) {
    suspend fun getPsychologicalProgrammes(list: ArrayList<HealthCareModel>)=repo.getPsychologicalProgrammes(list)
    suspend fun FamilyLifeProgrammes(list: ArrayList<HealthCareModel>)=repo.FamilyLifeProgrammes(list)
    suspend fun getUserExperiance(list: ArrayList<UserExperienceModel>)=repo.getUserExperiance(list)
}