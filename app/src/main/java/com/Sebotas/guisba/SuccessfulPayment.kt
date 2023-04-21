package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class SuccessfulPayment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successful_payment)


        val btn: Button = findViewById(R.id.button2)
        btn.setOnClickListener {

                val intent: Intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
    }
}