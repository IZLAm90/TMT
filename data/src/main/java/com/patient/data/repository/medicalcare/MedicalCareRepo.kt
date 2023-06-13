package com.patient.data.repository.medicalcare

import com.patient.data.model.HealthCareModel
import com.patient.data.model.MedicalSecialtyModel

interface MedicalCareRepo {
    suspend fun getPsychologicalProgrammes():ArrayList<HealthCareModel>
}