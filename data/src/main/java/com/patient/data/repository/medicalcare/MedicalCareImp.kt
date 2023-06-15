package com.patient.data.repository.medicalcare

import com.patient.data.model.HealthCareModel

class MedicalCareImp:MedicalCareRepo {
    override suspend fun getPsychologicalProgrammes(list:ArrayList<HealthCareModel>): ArrayList<HealthCareModel> {
        return list
    }
}