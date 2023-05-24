package com.patient.data.repository

import com.patient.data.model.EndPointResponse
import com.patient.data.model.LoginResponse
import com.patient.data.model.ResultsData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface DataRepo {

    suspend fun getData(): Flow<Response<LoginResponse>>
}