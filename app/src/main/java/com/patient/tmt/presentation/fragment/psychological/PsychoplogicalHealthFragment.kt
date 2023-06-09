package com.patient.tmt.presentation.fragment.psychological

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentPsychoplogicalHealthBinding

class PsychologicalHealthFragment : BaseFragment(R.layout.fragment_psychoplogical_health) {
    private lateinit var binding:FragmentPsychoplogicalHealthBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPsychoplogicalHealthBinding.bind(view)
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            PsychologicalHealthFragment().apply {}
    }
}