package com.example.pedidocomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.core.os.bundleOf


class SelecComidaFragment : Fragment(R.layout.fragment_selec_comida) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNext = view.findViewById<Button>(R.id.btnSiguienteComida)
        val rgComida = view.findViewById<RadioGroup>(R.id.radioGroupComida)//obtenemos el valor del xml


        btnNext.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction().apply {
                val comidaSelec = when(rgComida.checkedRadioButtonId){
                    R.id.rbEnsalada -> "Ensalada"
                    R.id.rbPizza -> "Pizza"
                    R.id.rbHamburguesa -> "Hamburguesa"
                    else -> "sin comida"
                }

                val datosComida = bundleOf("comida" to comidaSelec)
                val extraFragment = SelecExtrasFragment()
                extraFragment.arguments = datosComida

                replace(R.id.fragmentContainerInicio, extraFragment)
                addToBackStack("DatosComida")
                commit()
            }
        }

    }

}