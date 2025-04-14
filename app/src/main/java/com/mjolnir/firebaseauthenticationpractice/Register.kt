package com.mjolnir.firebaseauthenticationpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    private lateinit var tvLogin: TextView
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        tvLogin=findViewById(R.id.tvLogin)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        btnRegister=findViewById(R.id.btnRegister)
        firebaseAuth=FirebaseAuth.getInstance()

        tvLogin.setOnClickListener {
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }

        btnRegister.setOnClickListener {
            val email=etEmail.text.trim().toString()
            val password=etPassword.text.trim().toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                signIn(email, password)
            }
            else{
                Toast.makeText(this,"Please Enter valid details.", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun signIn(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,"User Registered Successfully.", Toast.LENGTH_SHORT).show()
                    val intent=Intent(this,Login::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this,"Someting went wrong.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}