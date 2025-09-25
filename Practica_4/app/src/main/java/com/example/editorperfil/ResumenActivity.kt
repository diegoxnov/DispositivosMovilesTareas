package com.example.editorperfil

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResumenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resumen)

        val txtResult = findViewById<TextView>(R.id.txtRNombre)
        val name = intent.getStringExtra("NAME")
        val edad = intent.getIntExtra("YEAR", -1)
        val ciudad = intent.getStringExtra("CITY")
        val correo = intent.getStringExtra("CORREO")
        txtResult.text = "Mi nombre es $name $edad $ciudad $correo"

    }
}