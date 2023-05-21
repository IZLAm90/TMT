package com.patient.tmt.presentation.fragment.auth.forgetpassword.number

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentPhonCheckBinding


class PhonCheckFragment : Fragment() {
    lateinit var binding:FragmentPhonCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonCheckBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            conifermNum.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }


}