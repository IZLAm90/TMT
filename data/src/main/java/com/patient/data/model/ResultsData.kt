package com.patient.data.model

import com.google.gson.annotations.SerializedName

data class ResultsData(

    @SerializedName("gender") var gender: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("cell") var cell: String? = null,
    @SerializedName("nat") var nat: String? = null

)

