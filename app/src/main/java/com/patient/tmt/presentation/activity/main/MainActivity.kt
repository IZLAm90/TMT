package com.patient.tmt.presentation.activity.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.patient.data.cashe.PreferencesGateway
import com.patient.tmt.R
import com.patient.tmt.databinding.ActivityMainBinding
import com.patient.tmt.helper.MyContextWrapper
import dagger.hilt.android.AndroidEntryPoint
//8
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment)
        binding?.apply {
            navView.setupWithNavController(navController)
            navController.addOnDestinationChangedListener{controller,destination,arguments->
                if (destination.id == R.id.instantConsultationFragment || destination.id ==R.id.medicalSpecialtiesFragment){
                    binding.navView.visibility = View.GONE
                }else{
                    binding.navView.visibility = View.VISIBLE

                }

            }
        }

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