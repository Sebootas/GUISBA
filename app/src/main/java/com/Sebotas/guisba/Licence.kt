package com.Sebotas.guisba

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Licence : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences
    private lateinit var btnSave: Button

    private lateinit var etLicensePlate1: EditText
    private lateinit var etLicensePlate2: EditText
    private lateinit var etLicensePlate3: EditText
    private var editor: SharedPreferences.Editor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_licence)
        etLicensePlate1 = findViewById<EditText>(R.id.et_license_plate1)
        etLicensePlate2 = findViewById<EditText>(R.id.et_license_plate2)
        etLicensePlate3 = findViewById<EditText>(R.id.et_license_plate3)
        btnSave = findViewById<Button>(R.id.btn_save)
        preferences = getSharedPreferences("LICENSE_PLATES", MODE_PRIVATE)
        editor = preferences.edit()

        // Load saved license plates
        val licensePlate1 = preferences.getString("LICENSE_PLATE_1", "")
        val licensePlate2 = preferences.getString("LICENSE_PLATE_2", "")
        val licensePlate3 = preferences.getString("LICENSE_PLATE_3", "")
        etLicensePlate1.setText(licensePlate1)
        etLicensePlate2.setText(licensePlate2)
        etLicensePlate3.setText(licensePlate3)
        btnSave.setOnClickListener(View.OnClickListener {
            val licensePlate1 = etLicensePlate1.getText().toString()
            val licensePlate2 = etLicensePlate2.getText().toString()
            val licensePlate3 = etLicensePlate3.getText().toString()

            // Save license plates
            preferences?.edit()?.apply {
                val editor = this
                editor.putString("LICENSE_PLATE_1", licensePlate1)
                editor.putString("LICENSE_PLATE_2", licensePlate2)
                editor.putString("LICENSE_PLATE_3", licensePlate3)
                editor.apply()
            }
            Toast.makeText(this@Licence, "License plates saved", Toast.LENGTH_SHORT).show()
        })
    }
}
