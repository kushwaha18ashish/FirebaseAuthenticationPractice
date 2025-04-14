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

class Login : AppCompatActivity() {
    private lateinit var tvRegister:TextView
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        tvRegister=findViewById(R.id.tvRegister)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        firebaseAuth=FirebaseAuth.getInstance()

        tvRegister.setOnClickListener {
            val intent=Intent(this,Register::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            val email=etEmail.text.trim().toString()
            val password=etPassword.text.trim().toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                logIn(email, password)
            }
            else{
                Toast.makeText(this,"Please Enter valid details.",Toast.LENGTH_SHORT).show()
            }
        }



    }
    private fun logIn(email:String,password:String){
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,"User logged in successfully.", Toast.LENGTH_SHORT).show()
                    val intent=Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {

                    Toast.makeText(this,"User Doesn't Exists. Please register",Toast.LENGTH_SHORT).show()
                }
            }
    }
}