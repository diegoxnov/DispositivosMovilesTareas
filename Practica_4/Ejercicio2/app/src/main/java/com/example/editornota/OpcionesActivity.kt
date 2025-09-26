package com.example.editornota

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        val nota = intent.getStringExtra("NOTA")
        txtNota.text = nota // damos el valor de nota obtenida al textview

        //Atributos a restaurar
        val notaRest = savedInstanceState?.getString("Nota")
        if (notaRest != null) txtNota.setText(notaRest)

        btnEdit.setOnClickListener {
            val nota = Intent()
            finish()
        }

        btnCorreo.setOnClickListener {
            Toast.makeText(this,"Compartido por correo", Toast.LENGTH_LONG).show()
        }


    }
    override fun onSaveInstanceState(outState: Bundle) {//funcion para recurar el dato
        super.onSaveInstanceState(outState)
        outState.putString("Nota", txtNota.text.toString())
    }
}