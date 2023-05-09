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
        pseButton.setOnClickListener {val randomNumber = (Math.random() * 2).toInt()

                // Open the first screen.
            val intent = Intent(this, Nequi2::class.java)
            startActivity(intent)

        }




        val bankButton = findViewById<Button>(R.id.bancolombia)
        bankButton.setOnClickListener {val randomNumber = (Math.random() * 2).toInt()


            val intent = Intent(this, Bank2::class.java)
            startActivity(intent)

        }

        val btnq: Button = findViewById(R.id.tarjeta)
        btnq.setOnClickListener{
            val intent: Intent = Intent(this, Credit:: class.java)
            startActivity(intent)
        }

    }
}