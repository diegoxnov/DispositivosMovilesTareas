package com.example.editorperfil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
        val name = intent.getStringExtra(keyData().keyName)//recepcion de datos del formlario activity
        val edad = intent.getIntExtra(keyData().keyYear, -1)
        val ciudad = intent.getStringExtra(keyData().keyCity)
        val correo = intent.getStringExtra(keyData().keyCorreo)
        val btn = findViewById<Button>(R.id.btnAtras)
        txtResult.text = "Mi nombre es $name edad: $edad ciudad: $ciudad correo: $correo"


        btn.setOnClickListener {//logica despues de hacer click al boton
            val message = Intent()
            message.putExtra("RESULT","usuario $name fue registrado de manera exitosa")//enviando la data al formulario
            setResult(RESULT_OK, message)
            finish()
        }

    }
}