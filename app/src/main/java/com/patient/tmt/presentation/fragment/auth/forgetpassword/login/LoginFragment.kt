package com.patient.tmt.presentation.fragment.auth.forgetpassword.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding :FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_main_navigation)
        }
        binding.newAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_sigenUpFragment)
        }
        binding.forgetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgetPasswordFragment)
        }
    }
}