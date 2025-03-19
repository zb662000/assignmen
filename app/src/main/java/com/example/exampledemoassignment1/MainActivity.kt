package com.example.exampledemoassignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val buttonSuggest = findViewById<Button>(R.id.buttonSuggest)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textViewSuggestion = findViewById<TextView>(R.id.textViewSuggestion)

        buttonSuggest.setOnClickListener {
            val timeOfDay = editTextTime.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()) {
                "morning" -> "Go for a jog or have a healthy breakfast!"
                "mid-morning" -> "Time for a light snack or a short walk."
                "afternoon" -> "A great time to focus on work or studies."
                "mid-afternoon" -> "Have some coffee and refresh yourself!"
                "dinner" -> "Enjoy a nice meal with family or friends."
                else -> "Please enter a valid time of day."
            }
            textViewSuggestion.text = suggestion
        }

        buttonReset.setOnClickListener {
            editTextTime.text.clear()
            textViewSuggestion.text = ""
        }
    }
}