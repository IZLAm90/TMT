package com.patient.data.repository.data

import com.app.data.remote.UserApi
import com.patient.data.repository.DataRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataRepoImp @Inject constructor(private val api: UserApi): DataRepo {
    override suspend fun getData()= flow { emit(api.getData()) } }