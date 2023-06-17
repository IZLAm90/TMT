package com.patient.tmt.presentation.fragment.healthycare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.patient.base.BaseFragment
import com.patient.data.model.HealthCareModel
import com.patient.tmt.R

class HealthCareFragment : BaseFragment(R.layout.fragment_health_care) {
    private val viewModel by viewModels<HealthyCareViewModel>()
    private lateinit var binding : HealthCareFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list : ArrayList<HealthCareModel> = arrayListOf()
        list.add(HealthCareModel(R.drawable.controlofphobia,"السيطرة علي الرهاب"
            ,"حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.controlofphobia,"السيطرة علي الرهاب"
            ,"حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.controlofphobia,"السيطرة علي الرهاب"
            ,"حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.controlofphobia,"السيطرة علي الرهاب"
            ,"حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.controlofphobia,"السيطرة علي الرهاب"
            ,"حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.controlofphobia,"السيطرة علي الرهاب"
            ,"حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.controlofphobia,"السيطرة علي الرهاب"
            ,"حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"))
        viewModel.getPsychologicalProgrammes(list)
    }
}