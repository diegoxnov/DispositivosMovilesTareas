package com.example.editornota

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OpcionesActivity : AppCompatActivity() {

    private lateinit var txtNota: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_opciones)

        val btnCorreo = findViewById<Button>(R.id.btnCorreo)
        val btnEdit = findViewById<Button>(R.id.btnEdit)
        txtNota = findViewById(R.id.txtNota)

        //Atributos a restaurar
        val notaRest = savedInstanceState?.getString("Nota")
        if (notaRest != null) txtNota.setText(notaRest)




    }
    override fun onSaveInstanceState(outState: Bundle) {//funcion para recurar el dato
        super.onSaveInstanceState(outState)
        outState.putString("Nota", txtNota.text.toString())
    }
}