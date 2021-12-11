package com.example.projectappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class lencon : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lencon)

        auth = FirebaseAuth.getInstance()

        val bth: Button = findViewById(R.id.button4)

        val cm: TextView = findViewById(R.id.textView4)
        val inch: TextView = findViewById(R.id.textView5)
        val feet: TextView = findViewById(R.id.textView6)
        val yard: TextView = findViewById(R.id.textView7)
        val millimetre: TextView = findViewById(R.id.textView8)
        val convertbtn: Button = findViewById(R.id.button5)
        val inputvalue: EditText = findViewById(R.id.editTextTextPersonName5)

        convertbtn.setOnClickListener {
            var m = Integer.parseInt(inputvalue.getText().toString())
            var centimetre = m*100
            cm.setText("Centimetre - " + centimetre.toString() + "cm")

            var inches = m*39.37
            inch.setText("Inches - " + inches.toString() + "in")

            var ft = m*3.281
            feet.setText("Feet - " + ft.toString() + "ft")

            var yd = m*1.094
            yard.setText("Yard - " + yd.toString() + "yd")

            var mm = m*1000
            millimetre.setText("Millimetre - " + mm.toString() + "mm")
        }

        bth.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this@lencon, dashboardactivity::class.java))
            finish()
        }
    }
}