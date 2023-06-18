package com.patient.data.repository.medicalcare

import com.app.data.remote.UserApi
import com.patient.data.model.HealthCareModel
import javax.inject.Inject

class MedicalCareImp@Inject constructor(private val api: UserApi):MedicalCareRepo {
    override suspend fun getPsychologicalProgrammes(list:ArrayList<HealthCareModel>): ArrayList<HealthCareModel> {
        return list
    }

    override suspend fun FamilyLifeProgrammes(list: ArrayList<HealthCareModel>): ArrayList<HealthCareModel> {
        return list
    }
}