package com.example.ciclodevidaapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private lateinit var textViewContador: TextView //llamamos el id del activity main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //damos los valores a las variables
        textViewContador = findViewById(R.id.textViewContador)
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)
        //si hacemos click el contador auymenta
        btnAumentar.setOnClickListener {
            contador++
            textViewContador.text = "Contador: $contador"
        }

        Log.d("CICLO", "onCreate llamado")
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
    }


    // VIsualizar en log catr
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","onStart")//log para on start
    }
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume")//log para onResume
    }
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","onPause")//log para onPause
    }
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","onStop")//log paraonStop
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","onDestroy")//log para onDestroy
    }
        //salvamos los valores al pasar a segundo plano
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guarda el valor en objeto Bundle, para recuperarlo después.
        outState.putInt("CONTADOR", contador)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Recupera la información, esta es la importancia del objeto Bundle.
        contador = savedInstanceState.getInt("CONTADOR")
        textViewContador.text = "Contador: $contador"
    }
}
