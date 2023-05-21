package com.app.data.remote

import com.patient.data.model.EndPointResponse
import com.patient.data.model.ResultsData
import retrofit2.Response
import retrofit2.http.GET


interface UserApi {


    @GET("api/?results=5")
    suspend fun getData(): Response<EndPointResponse<ArrayList<ResultsData>>>
}