package com.patient.domain

import com.patient.data.repository.medicalrepo.MedicalSpecialtyRepo
import javax.inject.Inject

class MedicalUseCase @Inject constructor( private val repo: MedicalSpecialtyRepo) {
suspend fun getMdedicalData() = repo.getSpecialtyData()
    suspend fun getDoctors() = repo.getSpecialtyDoctors()
    suspend fun getUserFeedBack() = repo.getUserFeedBack()
}