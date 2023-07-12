package com.patient.data.repository.medicalrepo

import com.patient.data.model.DoctorsModel
import com.patient.data.model.MedicalSecialtyModel
import com.patient.data.model.UserExperienceModel

interface MedicalSpecialtyRepo {
    suspend fun getSpecialtyData(mediacal :ArrayList<MedicalSecialtyModel>): ArrayList<MedicalSecialtyModel>
    suspend fun getSpecialtyDoctors(): ArrayList<DoctorsModel>
    suspend fun getUserFeedBack(): ArrayList<UserExperienceModel>
}