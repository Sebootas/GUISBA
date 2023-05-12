package com.Sebotas.guisba

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ModifyPassword : AppCompatActivity() {

    private lateinit var db: DBHelper
    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var newPasswordEditText: EditText
    private lateinit var iden: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_password)

        db = DBHelper(this)

        uname = findViewById(R.id.usernameEditText)
        iden = findViewById<EditText>(R.id.id)
        pword = findViewById(R.id.currentPasswordEditText)
        newPasswordEditText = findViewById(R.id.newPasswordEditText)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val username = uname.text.toString()
            val password = pword.text.toString()
            val identext = iden.text.toString()
            val newPassword = newPasswordEditText.text.toString()

            if (db.checkuserpass(username, password, identext)) {
                db.updatePassword(username, newPassword)
                showToast("Password updated successfully!")
            } else {
                showToast("Invalid username or current password.")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
