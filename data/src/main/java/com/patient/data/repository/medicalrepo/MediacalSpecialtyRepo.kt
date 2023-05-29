package com.patient.data.repository.medicalrepo

import com.patient.data.model.MedicalSecialtyModel

interface MedicalSpecialtyRepo {
    suspend fun getSpecialtyData():ArrayList<MedicalSecialtyModel>

}