package com.example.bitfit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class InputDisplay : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inputdisplay)

        val name = findViewById<EditText>(R.id.foodinput)
        val cal = findViewById<EditText>(R.id.caloriesinput)
        val but = findViewById<Button>(R.id.addentry)

        but.setOnClickListener {

            val food = name.text.toString()
            val call = cal.text.toString()

            lifecycleScope.launch(IO) {
                (application as FoodApplication).db.foodDao().insert (
                    FoodEntity(
                        fname = food,
                        fcalories = call
                    )
                )
            }

            name.text.clear()
            cal.text.clear()

        }

    }
}