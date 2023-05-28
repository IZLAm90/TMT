package com.patient.tmt.presentation.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.patient.tmt.R
import com.patient.tmt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
//27
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
                if (destination.id == R.id.instantConsultationFragment){
                    binding.navView.visibility = View.GONE
                }

            }
        }

    }
}