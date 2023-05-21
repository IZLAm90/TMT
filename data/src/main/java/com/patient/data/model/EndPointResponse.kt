package com.patient.data.model

import com.google.gson.annotations.SerializedName

data class EndPointResponse<T>(
    @SerializedName("info") var info: Info? = Info(),
    @SerializedName("results") var data: T? = null
)

data class Info(

    @SerializedName("seed") var seed: String? = null,
    @SerializedName("results") var results: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("version") var version: String? = null

)


