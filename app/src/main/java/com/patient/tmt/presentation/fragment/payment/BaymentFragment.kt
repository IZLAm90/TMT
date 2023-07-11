package com.patient.tmt.presentation.fragment.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentBaymentBinding


class BaymentFragment : BaseFragment(R.layout.fragment_bayment) {
    private lateinit var binding : FragmentBaymentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentBaymentBinding.bind(view)
        bindView()

    }
    fun bindView(){
        binding.apply {
            back.setOnClickListener {
                findNavController().navigateUp()
            }

        }
    }

}