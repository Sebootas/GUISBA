package com.Sebotas.guisba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Bank2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank2)

        val editText = findViewById<TextInputEditText>(R.id.edit_text)
        val button = findViewById<MaterialButton>(R.id.button)

        button.setOnClickListener {
            val username = editText.text.toString()

            if (TextUtils.isEmpty(username)) {
                editText.error = "Please enter your username"
            } else if (username.length % 2 == 0) {
                val intent = Intent(this, SuccessfulPayment::class.java)
                startActivity(intent)
            } else if (username.length % 2 == 1){
                val intent = Intent(this, PaymentFailed::class.java)
                startActivity(intent)
            }
        }
    }
}
