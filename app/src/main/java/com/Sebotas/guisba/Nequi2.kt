package com.Sebotas.guisba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class Nequi2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nequi2)

        val editText = findViewById<TextInputEditText>(R.id.phone_edit_text)
        val button = findViewById<MaterialButton>(R.id.button)

        button.setOnClickListener {

            val phoneNumber = editText.text.toString()

            // validate phone number format
            val phonePattern = Pattern.compile("^[0-9]{10}\$")
            val phoneMatcher = phonePattern.matcher(phoneNumber)

            if (!phoneMatcher.matches()) {
                editText.error = "Please enter a valid phone number"
            } else {
                val lastDigit = phoneNumber.takeLast(1).toInt()
                if (lastDigit % 2 == 0) {
                    val intent = Intent(this, SuccessfulPayment::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, PaymentFailed::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
