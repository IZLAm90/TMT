package com.patient.tmt.presentation.activity.login

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.patient.data.cashe.PreferencesGateway
import com.patient.tmt.R
import com.patient.tmt.databinding.ActivityLoginBinding
import com.patient.tmt.helper.MyContextWrapper
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
        val prefrence = newBase?.let { PreferencesGateway(it) }
        val localeToSwitchTo = prefrence?.load("lang","ar")
        val localeUpdatedContext = localeToSwitchTo?.let { MyContextWrapper.wrap(newBase, it) }
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