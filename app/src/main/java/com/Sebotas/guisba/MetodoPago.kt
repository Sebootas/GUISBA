package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MetodoPago : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodo_pago)

        val btn: Button = findViewById(R.id.backBTN)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val btnq: Button = findViewById(R.id.tarjeta)
        btnq.setOnClickListener{
            val intent: Intent = Intent(this, Credit:: class.java)
            startActivity(intent)
        }

    }
}