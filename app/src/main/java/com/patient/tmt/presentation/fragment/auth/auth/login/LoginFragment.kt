package com.patient.tmt.presentation.fragment.auth.auth.login

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.data.cashe.PreferencesGateway
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentLoginBinding
import com.patient.tmt.helper.MyContextWrapper
import com.patient.tmt.helper.setTextWithDifferentColors
import com.patient.tmt.presentation.activity.login.LoginActivity
import com.patient.tmt.presentation.activity.splash.SplashActivity.Companion.lang
 const val TAG="IslamLoginFragment"
class LoginFragment : BaseFragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var preferenc :PreferencesGateway
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        preferenc= activity?.applicationContext?.let { PreferencesGateway(it) }!!
        binding.apply {
            val colors = intArrayOf(Color.WHITE, resources.getColor(R.color.appColor))
            yourHealth.setTextWithDifferentColors(resources.getString(R.string.yourHealth), *colors)
            loginBtn.setOnClickListener {
                preferenc?.update("userName","islamaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                Log.d(TAG, "onViewCreated: ${preferenc?.load("userName","")} ")
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
            eng.setOnClickListener {
//                prefrence?.save("lang","en")
                Log.d("islam", "onViewCreated:${preferenc?.load("lang","ar")} ")
                lang ="en"
                val intent = Intent(context, LoginActivity::class.java)
                context?.startActivity(intent)
            }
            Arabic.setOnClickListener {
//                prefrence?.save("lang","ar")
//                Log.d("islam", "onViewCreated:${prefrence?.load("lang","ar")} ")
                lang="ar"
                val intent = Intent(context, LoginActivity::class.java)
                intent.putExtra("lang","ar")
                context?.startActivity(intent)

            }

        }

    }

}