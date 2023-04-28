package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btn: Button = findViewById(R.id.pagar)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, MetodoPago:: class.java)
            startActivity(intent)
        }

        val btn1: Button = findViewById(R.id.modificarcuenta)
        btn1.setOnClickListener{
            val intent: Intent = Intent(this, ModifyMenu:: class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.logOut)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, FirstScreen:: class.java)
            startActivity(intent)
        }
    }
}