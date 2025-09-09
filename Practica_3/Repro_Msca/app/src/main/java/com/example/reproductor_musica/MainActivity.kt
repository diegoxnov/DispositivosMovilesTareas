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

        //definimos los atributos que usaremos

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
        //funcion para comenzar la cancion
        private fun startSong() {
            mediaPlayer?.release() // Liberar si había una canción cargada antes
            mediaPlayer = MediaPlayer.create(this, playlist[currentSongIndex])
            mediaPlayer?.start() //reproduccion
            btnPlay.text = "Pausa" // cambiamos a pausa el texto de la cancion
            txtDebajo.text = songNames[currentSongIndex]

            // Cuando termine la canción, pasar automáticamente a la siguiente
            mediaPlayer?.setOnCompletionListener {
                changeSong(1)
            }
        }
        //pausa de la cancion
        private fun pauseSong() {
            mediaPlayer?.pause()
            btnPlay.text = "Reproducir"//se cambia el nombre
        }

        private fun resumeSong() {
            mediaPlayer?.start()//continuar cancion
            btnPlay.text = "Pausa"//cambiar el texto
        }

        private fun changeSong(direction: Int) {//cambiamos de cancion
            currentSongIndex += direction

            // Si te sales de rango, vuelve al inicio o final
            if (currentSongIndex < 0) currentSongIndex = playlist.size - 1 //si se vuelvce negativo si se retrocede desde la primera cancion salta al final de la lista
            if (currentSongIndex >= playlist.size) currentSongIndex = 0 //caso inverso de la ultima canciona la del inicio

            startSong()
        }

        override fun onDestroy() {//usamnos esta funcion en caso se cierre de manera incorrecta
            super.onDestroy()
            mediaPlayer?.release()//liberamos recursos
            mediaPlayer = null //dejamos en nulo indicar que no hay canciones
        }

}