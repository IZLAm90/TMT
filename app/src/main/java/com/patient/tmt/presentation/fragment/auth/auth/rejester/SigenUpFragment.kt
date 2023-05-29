package com.patient.tmt.presentation.fragment.auth.auth.rejester

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentSigenUpBinding
import com.patient.tmt.helper.isValidEmail
import com.patient.tmt.helper.isValidInput

class SigenUpFragment : BaseFragment(R.layout.fragment_sigen_up) {
    private lateinit var binding: FragmentSigenUpBinding
    private var gender = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding =FragmentSigenUpBinding.bind(view)
        binding.apply {
            male.setOnClickListener {
                gender = 1
                selectedMan.setImageResource(R.drawable.icon_selected)
                selectedWoman.setImageResource(R.drawable.not_selected)
            }
            female.setOnClickListener {
                gender = 2
                selectedWoman.setImageResource(R.drawable.icon_selected)
                selectedMan.setImageResource(R.drawable.not_selected)
            }
            sigenUp.setOnClickListener {
                if (FName.isValidInput() && SName.isValidInput() && UserNameEn.isValidInput() && Email.isValidEmail() && dateOfBirthe.isValidInput()){
                    findNavController().navigate(R.id.action_sigenUpFragment_to_phonCheckFragment)
                }else {
                    ErrorDialog("enter Valid data")
                }
            }
        }
    }
}