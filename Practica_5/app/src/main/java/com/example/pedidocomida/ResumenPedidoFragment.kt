package com.example.pedidocomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class ResumenPedidoFragment : Fragment(R.layout.fragment_resumen_pedido) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnConfirm = view.findViewById<Button>(R.id.btnConfirmar)
        val btnEdit = view.findViewById<Button>(R.id.btnEditar)
        val txtPedido = view.findViewById<TextView>(R.id.txtPedidoCompleto)

        val comida = arguments?.getString("comida") ?: "sin comida"
        val extra = arguments?.getString("extra") ?: "sin extra"

        txtPedido.text = "Tu pedido completo: $comida Extra $extra"
        btnConfirm.setOnClickListener {
            Toast.makeText(requireContext(), "PedidoConfirmado", Toast.LENGTH_LONG).show()


        }

    }

}