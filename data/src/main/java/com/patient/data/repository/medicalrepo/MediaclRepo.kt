package com.patient.data.repository.medicalrepo

import com.app.data.remote.UserApi
import com.patient.data.model.DoctorsModel
import com.patient.data.model.MedicalSecialtyModel
import javax.inject.Inject

class MedicalRepoImp @Inject constructor(private val api: UserApi)  : MedicalSpecialtyRepo{
     var mediacal :ArrayList<MedicalSecialtyModel> = arrayListOf()
     var doctors :ArrayList<DoctorsModel> = arrayListOf()
    override suspend fun getSpecialtyData(): ArrayList<MedicalSecialtyModel> {
        mediacal.add(MedicalSecialtyModel("islam", 0))
        mediacal.add(MedicalSecialtyModel("ahmed", 0))
        mediacal.add(MedicalSecialtyModel("ali", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        mediacal.add(MedicalSecialtyModel("mohamed", 0))
        return mediacal
    }

    override suspend fun getSpecialtyDoctors(): ArrayList<DoctorsModel> {
        doctors.add(DoctorsModel("islam",0,"sdsd","4.5","طب عام"))
        doctors.add(DoctorsModel("islam",1,"sddsfsd","4.5","طب عام"))
        doctors.add(DoctorsModel("islam",2,"fssfsf","4.5","طب عام"))
        doctors.add(DoctorsModel("islam",3,"fsffsf","5.0","طب عام"))
        doctors.add(DoctorsModel("islam",4,"sfsfds","4.9","طب عام"))
        doctors.add(DoctorsModel("islam",5,"fsdsds","4.8","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
        doctors.add(DoctorsModel("islam",6,"sfdfss","4.7","طب عام"))
       return  doctors
    }
}