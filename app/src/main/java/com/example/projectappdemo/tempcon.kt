package com.example.projectappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class tempcon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tempcon)

        val f: TextView = findViewById(R.id.textView4)
        val k: TextView = findViewById(R.id.textView5)

        val bth: Button = findViewById(R.id.button4)
        val convertbtn: Button = findViewById(R.id.button5)
        val inputvalue: EditText = findViewById(R.id.editTextTextPersonName5)

        convertbtn.setOnClickListener {
            var m = Integer.parseInt(inputvalue.getText().toString())
            var fa = m*1.8+32
            f.setText("Farenheit - " + fa.toString() + "F")

            var ke = m+273.15
            k.setText("Kelvin - " + ke.toString() + "K")
        }

        bth.setOnClickListener {
            startActivity(Intent(this@tempcon, dashboardactivity::class.java))
            finish()
        }
    }
}