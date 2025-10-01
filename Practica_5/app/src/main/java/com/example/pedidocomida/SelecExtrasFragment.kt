package com.example.pedidocomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.pedidocomida.Categoria

class TiposExtra{
    public val papa = "papa"
    public val bebida = "bebida"
    public val postre = "postre"

}



class SelecExtrasFragment : Fragment(R.layout.fragment_selec_extras) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val objTiposExtra = TiposExtra()
        val objCat = Categoria()
        val btnNext = view.findViewById<Button>(R.id.btnExtrasNext)
        val btnBack = view.findViewById<Button>(R.id.btnExtrasBack)
        val rgExtra = view.findViewById<RadioGroup>(R.id.radioGroupExtra)
        val txtProceso = view.findViewById<TextView>(R.id.textViewProceso)

        val comida = arguments?.getString(objCat.comida) ?: ""// obtenemos la comida del fragment comida
        txtProceso.text = "Tu selección de comida es: $comida"

        btnBack.setOnClickListener {
            //volver al fragment anterior para editar comida
            findNavController().popBackStack()
        }


        btnNext.setOnClickListener {

                val extraSelect = when(rgExtra.checkedRadioButtonId){
                    R.id.rbPapa -> objTiposExtra.papa
                    R.id.rbBebida -> objTiposExtra.bebida
                    R.id.rbPostre -> objTiposExtra.postre
                    else -> "sin extras"
                }

                val datosPostreComida = bundleOf("comida" to comida, "extra" to extraSelect)

                findNavController().navigate(R.id.action_selecExtrasFragment_to_resumenPedidoFragment, datosPostreComida)
        }

    }
}