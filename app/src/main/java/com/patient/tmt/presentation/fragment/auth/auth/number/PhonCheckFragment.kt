package com.patient.tmt.presentation.fragment.auth.auth.number

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentLoginBinding
import com.patient.tmt.databinding.FragmentPhonCheckBinding


class PhonCheckFragment :  BaseFragment(R.layout.fragment_phon_check) {
   private lateinit var binding:FragmentPhonCheckBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhonCheckBinding.bind(view)
        binding.apply {
            confirmNum.setOnClickListener {
                findNavController().navigate(R.id.action_otpFragment_to_loginFragment)
            }
        }
    }


}