package com.patient.domain

import android.os.RemoteException
import android.util.AndroidException
import android.util.Log
import com.patient.data.model.EndPointResponse
import com.patient.data.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.transform
import retrofit2.Response
import java.io.IOException
import java.net.*

inline fun <T ,R> Flow<Response<EndPointResponse<T>>>.transFormREsponseData(
    crossinline onSuccess: suspend FlowCollector<R>.(T) -> Unit
): Flow<R> {
    return transform {
        when {
            it.isSuccessful && it.body() != null && it.body()?.data!= null -> {onSuccess(it.body()!!.data!!)}
            it.code() == 401 -> throw Throwable(Constants.ERROR_API.UNAUTHRIZED)
            it.code() == 404 -> throw Throwable(Constants.ERROR_API.NOT_FOUND)
            it.code() == 500 -> throw Throwable(Constants.ERROR_API.SERVER_ERROR)
            else -> {
                Log.e("code", it.code().toString() + "," + it.errorBody().toString())
                throw Throwable().handleException()
            }
        }
    }
}
fun Throwable.handleException(): Throwable {
    return if (this is AndroidException || this is RemoteException || this is BindException || this is PortUnreachableException || this is SocketTimeoutException || this is UnknownServiceException || this is UnknownHostException || this is IOException || this is ConnectException || this is NoRouteToHostException) {
        Throwable(Constants.ERROR_API.CONNECTION_ERROR)
    } else {
        this
    }
}
