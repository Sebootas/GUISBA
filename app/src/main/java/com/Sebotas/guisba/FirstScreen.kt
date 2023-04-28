package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class FirstScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)



        val btn: Button = findViewById(R.id.signup)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity:: class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.login)
        btn2.setOnClickListener{
            val intent: Intent = Intent(this, LogIn:: class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        // Show a dialog asking the user if they really want to exit the app
        AlertDialog.Builder(this)
            .setTitle("Exit app?")
            .setMessage("Are you sure you want to exit the app?")
            .setPositiveButton("Yes") { _, _ ->
                finishAffinity() // This will completely close the app
            }
            .setNegativeButton("No", null)
            .show()
    }

}