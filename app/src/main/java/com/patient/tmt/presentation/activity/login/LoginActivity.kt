package com.patient.tmt.presentation.activity.login

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.patient.tmt.databinding.ActivityLoginBinding
import com.patient.tmt.helper.MyContextWrapper
import com.patient.tmt.presentation.activity.splash.SplashActivity.Companion.lang
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun attachBaseContext(newBase: Context?) {
//        val prefrence = newBase?.let { PreferencesGateway(it) }
//        val localeToSwitchTo = prefrence?.load("lang","ar")

        val localeUpdatedContext = newBase?.let { MyContextWrapper.wrap(it, lang) }
        super.attachBaseContext(localeUpdatedContext)
//            LANG =  prefrence?.load("lang","ar")
//            var theme = SharedHelper.getTheme(this)
//            when (theme) {
//                "dark" -> AppCompatDelegate.setDefaultNightMode(
//                    AppCompatDelegate.MODE_NIGHT_YES
//                )
//                "light" -> AppCompatDelegate.setDefaultNightMode(
//                    AppCompatDelegate.MODE_NIGHT_NO
//                )
//                else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//            }

    }

}