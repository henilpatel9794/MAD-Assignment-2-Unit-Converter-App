package com.example.projectappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class volcon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volcon)

        val ml: TextView = findViewById(R.id.textView4)
        val cm: TextView = findViewById(R.id.textView5)
        val gl: TextView = findViewById(R.id.textView6)
        val b: TextView = findViewById(R.id.textView7)
        val bth: Button = findViewById(R.id.button4)
        val convertbtn: Button = findViewById(R.id.button5)
        val inputvalue: EditText = findViewById(R.id.editTextTextPersonName5)

        convertbtn.setOnClickListener {
            var m = Integer.parseInt(inputvalue.getText().toString())
            var mil = m*1000
            ml.setText("Millilitre - " + mil.toString() + "ml")

            var cubm = m*0.001
            cm.setText("Cubicmetre - " + cubm.toString() + "m3")

            var gal = m*0.2641
            gl.setText("Gallon - " + gal.toString() + "gal")

            var bar = m*0.0062
            b.setText("Barrel - " + bar.toString() + "bl")

        }

        bth.setOnClickListener {
            startActivity(Intent(this@volcon, dashboardactivity::class.java))
            finish()
        }
    }
}