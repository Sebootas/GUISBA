package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Vehicles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)

        val btn: Button = findViewById(R.id.backBTN)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, ModifyMenu:: class.java)
            startActivity(intent)
        }


        val btn1: Button = findViewById(R.id.add_vehicles)
        btn1.setOnClickListener{
            val intent: Intent = Intent(this, Licence:: class.java)
            startActivity(intent)
        }
    }
}