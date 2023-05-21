package com.patient.domain

import com.patient.data.model.ResultsData
import com.patient.data.repository.DataRepo
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository :DataRepo) {
    suspend fun getData()=repository.getData().
    transFormREsponseData<ArrayList<ResultsData>, ArrayList<ResultsData>> {

    }
}