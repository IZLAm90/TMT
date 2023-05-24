package com.patient.tmt.presentation.activity.splash

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.patient.base.BaseActivity
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentSplashBinding
import com.patient.tmt.presentation.activity.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class SplashActivity : BaseActivity(R.layout.fragment_splash) {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                startActivity(LoginActivity::class.java)
            }
        }
    }
}

