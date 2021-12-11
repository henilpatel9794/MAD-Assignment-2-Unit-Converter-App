package com.example.projectappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class dashboardactivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboardactivity)

        auth = FirebaseAuth.getInstance()

        val logout: Button = findViewById(R.id.button10)
        val len: Button = findViewById(R.id.button6)
        val wt: Button = findViewById(R.id.button7)
        val tp: Button = findViewById(R.id.button8)
        val vol: Button = findViewById(R.id.button9)

        len.setOnClickListener {
            startActivity(Intent(this@dashboardactivity, lencon::class.java))
            finish()
        }

        wt.setOnClickListener {
            startActivity(Intent(this@dashboardactivity, wtcon::class.java))
            finish()
        }

        tp.setOnClickListener {
            startActivity(Intent(this@dashboardactivity, tempcon::class.java))
            finish()
        }

        vol.setOnClickListener {
            startActivity(Intent(this@dashboardactivity, volcon::class.java))
            finish()
        }

        logout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this@dashboardactivity, MainActivity::class.java))
            finish()
        }
    }
}