package com.Sebotas.guisba

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.Sebotas.guisba.databinding.ActivityBancolombia1Binding

class Bancolombia1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bancolombia1)

        // Initialize views
        val clientTypeSpinner: Spinner = findViewById(R.id.clientTypeSpinner)
        val selectedClientTypeTextView: TextView = findViewById(R.id.selectedClientTypeTextView)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)

        // Set up the dropdown menu
        val clientTypes = arrayOf("Type A", "Type B", "Type C")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, clientTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        clientTypeSpinner.adapter = adapter

        // Set up the button click listeners
        button1.setOnClickListener {
            // TODO: add logic for button 1 click
        }

        button2.setOnClickListener {
            // TODO: add logic for button 2 click
        }

        // Set up the client type selection listener
        clientTypeSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedClientTypeTextView.text = "Selected client type: ${clientTypes[position]}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedClientTypeTextView.text = ""
            }
        })
    }
}