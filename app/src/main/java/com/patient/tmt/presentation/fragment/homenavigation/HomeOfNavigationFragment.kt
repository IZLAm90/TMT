package com.patient.tmt.presentation.fragment.homenavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentHomeOfNavigationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeOfNavigationFragment : BaseFragment(R.layout.fragment_home_of_navigation) {

    private lateinit var binding : FragmentHomeOfNavigationBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeOfNavigationBinding.bind(view)
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        binding.apply {
            SpecialToke.setOnClickListener {
                findNavController().navigate(R.id.action_homeOfNavigationFragment_to_medicalSpecialtiesFragment)
            }
        }

    }


}