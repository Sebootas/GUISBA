package com.Sebotas.guisba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var cpword: EditText
    private lateinit var iden: EditText
    private lateinit var signupbtn: Button
    private lateinit var db: DBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.backBTN)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, FirstScreen:: class.java)
            startActivity(intent)
        }


        uname = findViewById<EditText>(R.id.username)
        pword = findViewById<EditText>(R.id.password)
        cpword = findViewById<EditText>(R.id.repassword)
        iden = findViewById<EditText>(R.id.email)

        signupbtn = findViewById(R.id.signupbtn)

        db = DBHelper(this)


        signupbtn.setOnClickListener {
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val cpwordtext = cpword.text.toString()
            val identext = iden.text.toString()
            val savedata = db.insertdata(unametext, pwordtext, identext)

            if (TextUtils.isEmpty (unametext) || TextUtils.isEmpty (pwordtext) || TextUtils.isEmpty (cpwordtext) || TextUtils.isEmpty (identext) ) {
                Toast.makeText(this, "Add Username, Password & Conform Password", Toast.LENGTH_SHORT).show()
            }
            else{
                if (pwordtext.equals(cpwordtext)) {
                    if (savedata==true){
                        Toast.makeText(this,"Signup Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent (applicationContext, LogIn::class.java)
                        startActivity (intent)
                    }
                    else{
                        Toast.makeText(this,"User Exists", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            }

        }





    }
}
