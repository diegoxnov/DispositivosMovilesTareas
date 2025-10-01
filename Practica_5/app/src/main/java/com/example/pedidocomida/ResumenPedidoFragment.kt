package com.example.pedidocomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.pedidocomida.Categoria
class ResumenPedidoFragment : Fragment(R.layout.fragment_resumen_pedido) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val objCat = Categoria()
        val btnConfirm = view.findViewById<Button>(R.id.btnEditar)
        val btnEdit = view.findViewById<Button>(R.id.btnConfirmar)
        val txtPedido = view.findViewById<TextView>(R.id.txtPedidoCompleto)

        val comida = arguments?.getString(objCat.comida) ?: "sin comida"
        val extra = arguments?.getString(objCat.extra) ?: "sin extra"

        txtPedido.text = "Tu pedido completo: $comida Extra $extra"
        btnConfirm.setOnClickListener {

            Toast.makeText(requireContext(), "PedidoConfirmado", Toast.LENGTH_LONG).show()
            findNavController().popBackStack(R.id.inicioFragment,false)

        }

        btnEdit.setOnClickListener {
            // Enviar resultado, SelecComidaFragment reciba la comida a editar
            val result = bundleOf(objCat.comida to comida)
            setFragmentResult("editarPedido", result)
            findNavController().popBackStack(R.id.selecComidaFragment, false)

        }

    }

}