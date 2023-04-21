package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class Credit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        val btn: Button = findViewById(R.id.pay)
        btn.setOnClickListener {
            val name = findViewById<TextInputLayout>(R.id.name)
            val id = findViewById<TextInputLayout>(R.id.id)
            val phone = findViewById<TextInputLayout>(R.id.phone)
            val cardNumber = findViewById<TextInputLayout>(R.id.card_number)
            val cvv = findViewById<TextInputLayout>(R.id.cvv)
            val month = findViewById<TextInputLayout>(R.id.month)
            val year = findViewById<TextInputLayout>(R.id.year)
            val installments = findViewById<TextInputLayout>(R.id.installments)


            if (name.toString().equals(null) || id.toString().equals("") ||
                phone.toString().trim().equals(null) || cardNumber.toString().trim().equals(null) ||
                cvv.toString().trim().equals(null) || month.toString().trim().equals(null) ||
                year.toString().trim().equals(null) || installments.toString().trim().equals(null))
            {
                Toast.makeText(applicationContext, "Missing payment details", Toast.LENGTH_LONG).show()
            } else {
                val intent: Intent = Intent(this, SuccessfulPayment::class.java)
                startActivity(intent)
            }

        }
    }
}