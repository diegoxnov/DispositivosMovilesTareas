package com.example.pedidocomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class InicioFragment : Fragment(R.layout.fragment_inicio) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnPedido = view.findViewById<Button>(R.id.btnNuevoPedido)

        btnPedido.setOnClickListener {

            findNavController().navigate(R.id.action_inicioFragment_to_selecComidaFragment)

//            requireActivity().supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragmentContainerInicio, SelecComidaFragment())
//                commit()
//            }
        }

    }

}