package com.example.recyclerviewapp.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.Usuario

class UsuarioViewHolder(view:View): RecyclerView.ViewHolder(view){

    private val txtNombre = view.findViewById<TextView>(R.id.txtNombre)
    private val txtEdad = view.findViewById<TextView>(R.id.txtEdad)
    private val txtCorreo = view.findViewById<TextView>(R.id.txtCorreo)
    private val btnDelete = view.findViewById<ImageButton>(R.id.btnEliminar)

    fun bind(user: Usuario, onDelete: (Int) -> Unit){
        txtNombre.text = user.nombre
        txtEdad.text = user.edad.toString()
        txtCorreo.text = user.email
        btnDelete.setOnClickListener {
            val pos = bindingAdapterPosition
            if( pos != RecyclerView.NO_POSITION)
            {
                onDelete(pos)
            }
        }
        fun bind(
            user: Usuario,
            onDelete: (Int) -> Unit,
            onEdit: (Int, Usuario) -> Unit
        ){
            txtNombre.text = user.nombre
            txtEdad.text = user.edad.toString()
            txtCorreo.text = user.email

            // Botón eliminar (ya lo tenías)
            btnDelete.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    onDelete(pos)
                }
            }

            // 🔹 Long click en todo el itemView
            itemView.setOnLongClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    AlertDialog.Builder(itemView.context)
                        .setTitle("Acción")
                        .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                            when (which) {
                                0 -> { // Editar
                                    showEditDialog(user, pos, onEdit)
                                }
                                1 -> { // Eliminar
                                    onDelete(pos)
                                }
                            }
                        }
                        .show()
                }
                true
            }
        }


        private fun showEditDialog(usuario: Usuario, pos: Int, onEdit: (Int, Usuario) -> Unit) {
            val context = itemView.context
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_usuario, null)

            val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
            val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
            val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

            // valores actuales
            editNombre.setText(usuario.nombre)
            editEdad.setText(usuario.edad.toString())
            editCorreo.setText(usuario.email)

            AlertDialog.Builder(context)
                .setTitle("Editar usuario")
                .setView(dialogView)
                .setPositiveButton("Guardar") { _, _ ->
                    usuario.nombre = editNombre.text.toString()
                    usuario.edad = editEdad.text.toString().toIntOrNull() ?: usuario.edad
                    usuario.email = editCorreo.text.toString()
                    onEdit(pos, usuario)
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }


    }


}

