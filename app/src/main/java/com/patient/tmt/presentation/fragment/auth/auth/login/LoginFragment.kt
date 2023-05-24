package com.patient.tmt.presentation.fragment.auth.auth.login

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentLoginBinding
import com.patient.tmt.helper.setTextWithDifferentColors


class LoginFragment : BaseFragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.apply {
            val colors = intArrayOf(Color.WHITE, resources.getColor(R.color.appColor))
            yourHealth.setTextWithDifferentColors(resources.getString(R.string.yourHealth), *colors)
            loginBtn.setOnClickListener {
//                if (EtUserName.text.isNullOrEmpty()) {
//                    ErrorDialog("Enter The User Name")
//                } else if (EtPassword.text.isNullOrEmpty()) {
//                    ErrorDialog("Enter The PassWord")
//                } else
                    findNavController().navigate(R.id.action_loginFragment_to_viewPagerFragment)
            }
            newAccount.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_sigenUpFragment)
            }
            forgetPassword.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_forgetPasswordFragment2)
            }
        }

    }
}