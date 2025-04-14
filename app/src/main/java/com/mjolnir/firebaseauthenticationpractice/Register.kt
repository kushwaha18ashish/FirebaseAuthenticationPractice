package com.mjolnir.firebaseauthenticationpractice

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    private lateinit var tvLogin: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        tvLogin=findViewById(R.id.tvLogin)
        tvLogin.setOnClickListener {
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }

    }
}