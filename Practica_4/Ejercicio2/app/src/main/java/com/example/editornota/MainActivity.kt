package com.example.editornota

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtNota: EditText//atributo para restauraci[on

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnInsert = findViewById<Button>(R.id.btnInsert)
        txtNota = findViewById(R.id.etxtNota)

        //atributos a restaurar
        val notaRestaurado = savedInstanceState?.getString("Nota")
        if (notaRestaurado != null) txtNota.setText(notaRestaurado)

        btnInsert.setOnClickListener {//logica despues de hacer click
            val nota = txtNota.text.toString()

            val enviar = Intent(this, OpcionesActivity::class.java)//enviamos el dato a la otra activity
            enviar.putExtra("NOTA", nota)
            startActivity(enviar)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Nota", txtNota.text.toString())
    }
}