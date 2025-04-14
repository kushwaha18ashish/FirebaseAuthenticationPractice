package com.mjolnir.firebaseauthenticationpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var btnSignOut:Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        firebaseAuth=FirebaseAuth.getInstance()

        btnSignOut=findViewById(R.id.btnLogout)

        btnSignOut.setOnClickListener {
            firebaseAuth.signOut()

            val intent= Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }

    }
}