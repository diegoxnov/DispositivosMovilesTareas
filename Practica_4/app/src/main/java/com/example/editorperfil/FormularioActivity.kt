package com.example.editorperfil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario)
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)//atributos del xml
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCiudad = findViewById<EditText>(R.id.txtCiudad)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)

        btnContinuar.setOnClickListener {
            val nombre = txtNombre.text.toString()//obtenemos los valores de los atributos XML
            val edad = txtEdad.text.toString().toInt()
            val ciudad = txtCiudad.text.toString()
            val correo = txtCorreo.text.toString()

            val enviar = Intent(this, ResumenActivity::class.java)//le decimos a que activity se dirige el intent
            enviar.putExtra("Name",nombre)//atributos a enviar
            enviar.putExtra("YEAR",edad)
            enviar.putExtra("CITY",ciudad)
            enviar.putExtra("CORREO",correo)
            startActivity(intent)
        }
    }
}