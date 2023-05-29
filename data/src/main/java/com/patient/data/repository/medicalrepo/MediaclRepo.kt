package com.patient.data.repository.medicalrepo

import com.app.data.remote.UserApi
import com.patient.data.model.MedicalSecialtyModel
import javax.inject.Inject

class MedicalRepoImp @Inject constructor(private val api: UserApi)  : MedicalSpecialtyRepo{
    override suspend fun getSpecialtyData(): ArrayList<MedicalSecialtyModel> {
     val mediacal :ArrayList<MedicalSecialtyModel> = arrayListOf()
        mediacal.add(MedicalSecialtyModel("islam", 0))
        mediacal.add(MedicalSecialtyModel("ahmed", 0))
        mediacal.add(MedicalSecialtyModel("ali", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        return mediacal
    }
}