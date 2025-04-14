package com.mjolnir.firebaseauthenticationpractice

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    private lateinit var tvRegister:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        tvRegister=findViewById(R.id.tvRegister)

        tvRegister.setOnClickListener {
            val intent=Intent(this,Register::class.java)
            startActivity(intent)
            finish()
        }



    }
}