package com.example.projectappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class wtcon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wtcon)

        val g: TextView = findViewById(R.id.textView4)
        val mg: TextView = findViewById(R.id.textView5)
        val lb: TextView = findViewById(R.id.textView6)
        val oz: TextView = findViewById(R.id.textView7)
        val bth: Button = findViewById(R.id.button4)
        val convertbtn: Button = findViewById(R.id.button5)
        val inputvalue: EditText = findViewById(R.id.editTextTextPersonName5)

        convertbtn.setOnClickListener {
            var m = Integer.parseInt(inputvalue.getText().toString())
            var gm = m*1000
            g.setText("Gram - " + gm.toString() + "gm")

            var ml = m*1000000
            mg.setText("Milligram - " + ml.toString() + "mg")

            var pd = m*2.205
            lb.setText("Pound - " + pd.toString() + "lb")

            var ou = m*1.094
            oz.setText("Ounce - " + ou.toString() + "oz")

        }

        bth.setOnClickListener {
            startActivity(Intent(this@wtcon, dashboardactivity::class.java))
            finish()
        }
    }
}