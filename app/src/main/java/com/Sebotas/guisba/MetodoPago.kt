package com.Sebotas.guisba

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
        val pseButton = findViewById<Button>(R.id.pse)
        pseButton.setOnClickListener {
            val url = "https://www.pse.com.co/persona"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

            Handler().postDelayed({
                val intent2 = Intent(this, SuccessfulPayment::class.java)
                startActivity(intent2)
            }, 10000) // 10 second delay
        }

        val bankButton = findViewById<Button>(R.id.bancolombia)
        bankButton.setOnClickListener {
            val url = "https://www.bancolombia.com/personas"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

            Handler().postDelayed({
                val intent2 = Intent(this, SuccessfulPayment::class.java)
                startActivity(intent2)
            }, 10000) // 10 second delay
        }

        val btnq: Button = findViewById(R.id.tarjeta)
        btnq.setOnClickListener{
            val intent: Intent = Intent(this, Credit:: class.java)
            startActivity(intent)
        }

    }
}