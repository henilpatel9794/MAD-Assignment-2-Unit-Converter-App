package com.example.projectappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var auth:  FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val currentuser = auth.currentUser
        if(currentuser != null) {
            startActivity(Intent(this@MainActivity, dashboardactivity::class.java))
            finish()
        }
        login()
    }

    private fun login() {
        val signup: TextView = findViewById(R.id.textView)
        val loginButton: Button = findViewById(R.id.button)
        val emailid: EditText = findViewById(R.id.editTextTextPersonName)
        val passwd: EditText = findViewById(R.id.editTextTextPersonName2)

        loginButton.setOnClickListener {

            if (TextUtils.isEmpty(emailid.text.toString())) {
                emailid.setError("Please enter email")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(passwd.text.toString())) {
                passwd.setError("Please enter password")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(emailid.text.toString(), passwd.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(this@MainActivity, dashboardactivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Login failed, please try again! ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

        signup.setOnClickListener {
            startActivity(Intent(this, signupactivity::class.java))
            finish()
        }
    }
}

