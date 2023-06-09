package com.patient.data.model

import com.patient.data.cashe.PreferencesGateway
import java.io.Serializable

data class Patient(
    var accountId: Int,
    val answer: String,
    val branchId: Int,
    val code: Int,
    val confirmedUser: Int,
    val customCode: String,
    val fullnameAr: String,
    val fullnameEn: String,
    val gender: Int,
    val securityQuestion: String,
    val userName: String,
    var contractId: Int? = null,
    val addressAr: String? = null,
    val addresEn: String? = null,
    val birthDate: String? = null,
    val mobile: String? = null,
    val contractAr: String? = null,
    val contractEn: String? = null,
    val identityType:Int,
    val identityValue:String,
    val age:Int,
    val image:String?=null

) : Serializable {
//    fun getAddress(): String? {
//        return if (PreferencesGateway == "ar")
//            addressAr
//        else
//            addresE   n
//    }
//
//    fun getContract(): String? {
//        return if (PreferencesGateway == "ar")
//            contractAr
//        else
//            contractEn
//    }
}