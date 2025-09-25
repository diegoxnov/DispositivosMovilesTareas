package com.example.editorperfil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormularioActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText//atributos para guardar datos en caso de perdida
    private lateinit var txtEdad: EditText
    private lateinit var txtCiudad: EditText
    private lateinit var txtCorreo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario)
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)//atributos del xml
         txtNombre = findViewById(R.id.txtNombre)
         txtEdad = findViewById(R.id.txtEdad)
         txtCiudad = findViewById(R.id.txtCiudad)
         txtCorreo = findViewById(R.id.txtCorreo)



        // Restaurar datos si existen
        val nombreRest = savedInstanceState?.getString("nombre")
        val edadRest = savedInstanceState?.getInt("edad")
        val ciudadRest = savedInstanceState?.getString("ciudad")
        val correoRest = savedInstanceState?.getString("correo")
        if (nombreRest != null) txtNombre.setText(nombreRest)
        if (correoRest != null) txtCorreo.setText(correoRest)
        if (ciudadRest != null) txtCiudad.setText(ciudadRest)
        if (edadRest != null) txtEdad.setText(edadRest.toString())


        //codigo para esperar el resultado de resumen Activity
        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == RESULT_OK){
                val data = result.data
                val msg = data?.getStringExtra("RESULT")
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            }
        }

        btnContinuar.setOnClickListener {
            val nombre = txtNombre.text.toString()//obtenemos los valores de los atributos XML
            val edad = txtEdad.text.toString().toIntOrNull() ?: 0
            val ciudad = txtCiudad.text.toString()
            val correo = txtCorreo.text.toString()

            val enviar = Intent(this, ResumenActivity::class.java)//le decimos a que activity se dirige el intent
            enviar.putExtra("NAME",nombre)//atributos a enviar
            enviar.putExtra("YEAR",edad)
            enviar.putExtra("CITY",ciudad)
            enviar.putExtra("CORREO",correo)
            launcher.launch(enviar)
            //startActivity(enviar)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {//salvar datos en caso de perdida
        super.onSaveInstanceState(outState)
        outState.putString("nombre", txtNombre.text.toString())
        outState.putString("ciudad", txtCiudad.text.toString())
        outState.putString("correo", txtCorreo.text.toString())
        outState.putInt("edad", txtEdad.text.toString().toIntOrNull() ?: 0)
    }

}