package com.patient.data.repository.medicalcare

import com.patient.data.model.HealthCareModel
import com.patient.data.model.MedicalSecialtyModel
import com.patient.data.model.UserExperienceModel

interface MedicalCareRepo {
    suspend fun getPsychologicalProgrammes(list: ArrayList<HealthCareModel>):ArrayList<HealthCareModel>
    suspend fun FamilyLifeProgrammes(list: ArrayList<HealthCareModel>):ArrayList<HealthCareModel>
    suspend fun getUserExperiance(list: ArrayList<UserExperienceModel>):ArrayList<UserExperienceModel>
}