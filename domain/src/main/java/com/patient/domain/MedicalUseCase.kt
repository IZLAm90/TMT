package com.patient.domain

import com.patient.data.model.MedicalSecialtyModel
import com.patient.data.repository.medicalrepo.MedicalSpecialtyRepo
import javax.inject.Inject

class MedicalUseCase @Inject constructor(private val repo: MedicalSpecialtyRepo) {
    suspend fun getMdedicalData(mediacal :ArrayList<MedicalSecialtyModel>) = repo.getSpecialtyData(mediacal)
    suspend fun getDoctors() = repo.getSpecialtyDoctors()
    suspend fun getUserFeedBack() = repo.getUserFeedBack()
}