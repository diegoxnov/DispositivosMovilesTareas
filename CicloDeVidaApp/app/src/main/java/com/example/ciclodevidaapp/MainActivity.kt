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
    private lateinit var textViewContador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewContador = findViewById(R.id.textViewContador)
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)

        btnAumentar.setOnClickListener {
            contador++
            textViewContador.text = "Contador: $contador"
        }

        Log.d("CICLO", "onCreate llamado")
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
    }


    // Completar esto
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","onDestroy")
    }
    override fun onResume() {
        super.onResume()
    }
    override fun onPause() {
        super.onPause()
    }
    override fun onStop() {
        super.onStop()
    }
    override fun onDestroy() {
        super.onDestroy()
    }

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
