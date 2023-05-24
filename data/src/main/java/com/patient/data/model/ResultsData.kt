package com.patient.data.model

import com.google.gson.annotations.SerializedName

data class ResultsData(

    @SerializedName("gender") var gender: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("cell") var cell: String? = null,
    @SerializedName("nat") var nat: String? = null

)

data class LoginResponse(
    val patient: String,
    val success: Boolean,
    val message: String
)

data class ForGetPassActive(
    val serial: Int? = null,
    val mobile: String? = null,
    val activationCode: String? = null,
    val activated: Boolean
)

data class ForgetSucces(val successFlag: Int? = null)
