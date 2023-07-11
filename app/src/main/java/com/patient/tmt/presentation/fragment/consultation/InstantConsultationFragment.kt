package com.patient.tmt.presentation.fragment.consultation

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentInstantConsultationBinding
import com.patient.tmt.helper.DateAndTimeFormateUtil
import com.patient.tmt.helper.showDialogDate
import java.text.SimpleDateFormat
import java.util.*

class InstantConsultationFragment : BaseFragment(R.layout.fragment_instant_consultation), DatePickerDialog.OnDateSetListener {
    private lateinit var binding: FragmentInstantConsultationBinding
    var dateSelected: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInstantConsultationBinding.bind(view)
        binding.apply {
            consaltaion.setOnClickListener { findNavController().navigate(R.id.action_instantConsultationFragment_to_baymentFragment) }
            back.setOnClickListener {
                findNavController().navigateUp()
            }
            description.setSelection(0)
            forMe.setOnClickListener {
                forMe.setImageResource(R.drawable.icon_selected)
                forRelative.setImageResource(R.drawable.not_selected)
            }
            forRelative.setOnClickListener {
                forRelative.setImageResource(R.drawable.icon_selected)
                forMe.setImageResource(R.drawable.not_selected)
            }
            male.setOnClickListener {
                male.setImageResource(R.drawable.icon_selected)
                female.setImageResource(R.drawable.not_selected)
            }
            female.setOnClickListener {
                female.setImageResource(R.drawable.icon_selected)
                male.setImageResource(R.drawable.not_selected)
            }
            dateSelected = SimpleDateFormat(DateAndTimeFormateUtil.formteDatayyyyMMdd).format(Date())

            selectDate.setOnClickListener {
                this@InstantConsultationFragment.context?.let { it1 -> showDialogDate(it1,dateSelected,this@InstantConsultationFragment).show() }
            }


        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        dateSelected = "$year/${(month + 1)}/$dayOfMonth"
        binding.selectDate.text=dateSelected
        dateSelected = SimpleDateFormat(DateAndTimeFormateUtil.formteDatayyyyMMdd).format(Date())
    }


}