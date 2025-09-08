package com.example.interaccion_img

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //Creando la variable de la img
        val idImg = findViewById<ImageView>(R.id.imgIntegra)
        idImg.setOnClickListener {
            Toast.makeText(this, "Hola soy un Honda Integra gsr", Toast.LENGTH_SHORT).show()
        }
    }
}