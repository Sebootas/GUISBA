package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaymentFailed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_failed)


        val btn: Button = findViewById(R.id.button2)
        btn.setOnClickListener {

            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val btn0: Button = findViewById(R.id.button)
        btn0.setOnClickListener {

            val intent: Intent = Intent(this, MetodoPago::class.java)
            startActivity(intent)
        }
    }
}