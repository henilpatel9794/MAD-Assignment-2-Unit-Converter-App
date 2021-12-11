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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class signupactivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        register()
    }

    private fun register() {
        val username: EditText = findViewById(R.id.editTextTextPersonName3)
        val phoneno: EditText = findViewById(R.id.editTextTextPersonName4)
        val email: EditText = findViewById(R.id.editTextTextPersonName6)
        val password: EditText = findViewById(R.id.editTextTextPersonName7)
        val registerbutton: Button = findViewById(R.id.button3)

        registerbutton.setOnClickListener {
            if(TextUtils.isEmpty(username.text.toString())) {
                username.setError("Please enter user name ")
                return@setOnClickListener
            } else if(TextUtils.isEmpty(phoneno.text.toString())) {
                phoneno.setError("Please enter phone number ")
                return@setOnClickListener
            }else if(TextUtils.isEmpty(email.text.toString())) {
                email.setError("Please enter your email ")
                return@setOnClickListener
            }else if(TextUtils.isEmpty(password.text.toString())) {
                password.setError("Please enter password ")
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful) {
                        val currentUser = auth.currentUser
                        val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
                        currentUSerDb?.child("username")?.setValue(username.text.toString())
                        currentUSerDb?.child("phoneno")?.setValue(phoneno.text.toString())

                        Toast.makeText(this@signupactivity, "Registration Successful ", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@signupactivity, MainActivity::class.java))
                        finish()
                    }
                    else {
                        Toast.makeText(this@signupactivity, "Registration failed, please try again! ", Toast.LENGTH_LONG).show()
                    }
                }
        }



    }
}