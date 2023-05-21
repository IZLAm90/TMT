package com.patient.data

data class BaseResponse(val authorization: Authorization?=null)

data class Authorization(val type: String?=null,val accessToken:String?=null)

