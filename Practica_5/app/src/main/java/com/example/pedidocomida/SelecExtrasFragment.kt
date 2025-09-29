package com.example.pedidocomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class SelecExtrasFragment : Fragment(R.layout.fragment_selec_extras) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNext = view.findViewById<Button>(R.id.btnExtrasNext)
        val rgExtra = view.findViewById<RadioGroup>(R.id.radioGroupExtra)
        val txtProceso = view.findViewById<TextView>(R.id.textViewProceso)

        val comida = arguments?.getString("comida") ?: ""// obtenemos la comida del fragment comida
        txtProceso.text = "Tu selección de comida es: $comida"



    }
}