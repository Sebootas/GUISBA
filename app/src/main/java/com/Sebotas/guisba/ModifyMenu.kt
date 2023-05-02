package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ModifyMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_menu)

        val btn: Button = findViewById(R.id.backBTN)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, Home:: class.java)
            startActivity(intent)
        }

        val btn1: Button = findViewById(R.id.vehicles)
        btn1.setOnClickListener{
            val intent: Intent = Intent(this, Vehicles:: class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.account)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, Account:: class.java)
            startActivity(intent)
        }

    }
}