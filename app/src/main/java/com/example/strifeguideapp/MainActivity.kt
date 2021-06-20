package com.example.strifeguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val navController = findNavController(R.id.fragment)

       val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

       bottomNavigationView.setupWithNavController(navController)

    }
}