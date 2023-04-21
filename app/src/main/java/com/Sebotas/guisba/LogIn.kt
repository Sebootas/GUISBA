package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LogIn : AppCompatActivity() {

    private lateinit var loginbtn: Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var editit: EditText
    private lateinit var dbh: DBHelper


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        loginbtn = findViewById(R.id.start)
        edituser = findViewById<EditText>(R.id.username)
        editpword = findViewById<EditText>(R.id.password)
        editit = findViewById<EditText>(R.id.email)
        dbh = DBHelper(this)


        loginbtn.setOnClickListener{
            val useredtx = edituser.text.toString()
            val passedtx = editpword.text.toString()
            val idtext = editit.text.toString()
            if (TextUtils.isEmpty (useredtx) || TextUtils.isEmpty (passedtx) || TextUtils.isEmpty (idtext)){
                Toast.makeText(this, "Add Username, ID & Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbh.checkuserpass (useredtx, passedtx, idtext)
                if (checkuser==true){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Home::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Wrong Username, ID & Password", Toast.LENGTH_SHORT).show()
                }
            }
        }


        val btn: Button = findViewById(R.id.backBTN)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, FirstScreen:: class.java)
            startActivity(intent)
        }



    }

}