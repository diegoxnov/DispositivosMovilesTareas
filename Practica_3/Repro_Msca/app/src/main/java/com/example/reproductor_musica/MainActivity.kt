package com.example.reproductor_musica
//Autor Diego Nova Rosas
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.media.MediaPlayer
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {



        private lateinit var btnPrev: Button
        private lateinit var btnPlay: Button
        private lateinit var btnNext: Button
        private lateinit var txtDebajo: TextView

        private var mediaPlayer: MediaPlayer? = null
        private var currentSongIndex = 0

        // Lista de canciones gurdadas en el raw
        private val playlist = listOf(
            R.raw.timbaland_pure_devotion,
            R.raw.isaiah_falls_joyce_wrice
        )

        // Lista con nombres visibles para el usuario
        private val songNames = listOf("Canción 1", "Canción 2", "Canción 3")

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Vinculamos los elementos del xml
            btnPrev = findViewById(R.id.btnIzquierda)
            btnPlay = findViewById(R.id.btnCentro)
            btnNext = findViewById(R.id.btnDerecha)
            txtDebajo = findViewById(R.id.txtDebajo)

            // Mostrar el nombre de la primera canción
            txtDebajo.text = songNames[currentSongIndex]

            // Botón Play / Pause
            btnPlay.setOnClickListener {
                if (mediaPlayer == null) {
                    startSong()
                } else if (mediaPlayer!!.isPlaying) {
                    pauseSong()
                } else {
                    resumeSong()
                }
            }

            // Botón Anterior
            btnPrev.setOnClickListener {
                changeSong(-1)
            }

            // Botón Siguiente
            btnNext.setOnClickListener {
                changeSong(1)
            }
        }

        private fun startSong() {
            mediaPlayer?.release() // Liberar si había una canción cargada antes
            mediaPlayer = MediaPlayer.create(this, playlist[currentSongIndex])
            mediaPlayer?.start()
            btnPlay.text = "Pausa"
            txtDebajo.text = songNames[currentSongIndex]

            // Cuando termine la canción, pasar automáticamente a la siguiente
            mediaPlayer?.setOnCompletionListener {
                changeSong(1)
            }
        }

        private fun pauseSong() {
            mediaPlayer?.pause()
            btnPlay.text = "Reproducir"
        }

        private fun resumeSong() {
            mediaPlayer?.start()
            btnPlay.text = "Pausa"
        }

        private fun changeSong(direction: Int) {
            currentSongIndex += direction

            // Si te sales de rango, vuelve al inicio o final
            if (currentSongIndex < 0) currentSongIndex = playlist.size - 1
            if (currentSongIndex >= playlist.size) currentSongIndex = 0

            startSong()
        }

        override fun onDestroy() {
            super.onDestroy()
            mediaPlayer?.release()
            mediaPlayer = null
        }

}