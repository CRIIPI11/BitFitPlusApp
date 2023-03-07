package com.example.bitfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bitfit.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)

       binding = ActivityMainBinding.inflate(layoutInflater)
       val view = binding.root
       setContentView(view)

        val but = findViewById<Button>(R.id.newentry)
        but.setOnClickListener {
            val inte = Intent(this, InputDisplay::class.java)
            startActivity(inte)
        }

       val fragmentManager: FragmentManager = supportFragmentManager

       // define your fragments here
       val foodFragment: Fragment = FoodFragment()
       val summaryFragment: Fragment = SummaryFragment()

       val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

       // handle navigation selection
       bottomNavigationView.setOnItemSelectedListener { item ->
           lateinit var fragment: Fragment
           when (item.itemId) {
               R.id.log -> fragment = foodFragment
               R.id.sum -> fragment = summaryFragment
           }
           replaceFragment(fragment)
           true
       }
       // Set default selection
       bottomNavigationView.selectedItemId = R.id.log

    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainframe, fragment)
        fragmentTransaction.commit()
    }


}



