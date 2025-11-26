import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../viewmodels/user_view_model.dart';
import '../models/user.dart';
import 'user_form_screen.dart';

class UserListScreen extends StatefulWidget {
  const UserListScreen({super.key});

  @override
  State<UserListScreen> createState() => _UserListScreenState();
}

class _UserListScreenState extends State<UserListScreen> {
  bool soloActivos = false;

  @override
  Widget build(BuildContext context) {
    final viewModel = context.watch<UserViewModel>();

    final usuarios = soloActivos
        ? viewModel.usuarios.where((u) => u.activo).toList()
        : viewModel.usuarios;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Lista de Usuarios'),
        actions: [
          Row(
            children: [
              const Text("Activos"),
              Switch(
                value: soloActivos,
                onChanged: (v) => setState(() => soloActivos = v),
              ),
            ],
          )
        ],
      ),
      body: ListView.builder(
        itemCount: usuarios.length,
        itemBuilder: (context, index) {
          final user = usuarios[index];
          final realIndex = viewModel.usuarios.indexOf(user);

          return Card(
            child: ListTile(
              title: Text("${user.nombre} (${user.edad} años)"),
              subtitle: Text(
                  "${user.genero} - ${user.correo} - ${user.activo ? 'Activo' : 'Inactivo'}"),
              trailing: Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  IconButton(
                    icon: const Icon(Icons.edit),
                    onPressed: () async {
                      final actualizado = await Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (_) => UserFormScreen(
                            usuario: user,
                            indice: realIndex,
                          ),
                        ),
                      );

                      if (actualizado != null && actualizado is User) {
                        viewModel.editarUsuario(realIndex, actualizado);
                      }
                    },
                  ),
                  IconButton(
                    icon: const Icon(Icons.delete, color: Colors.red),
                    onPressed: () => viewModel.eliminarUsuario(realIndex),
                  ),
                ],
              ),
            ),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          final nuevoUsuario = await Navigator.push(
            context,
            MaterialPageRoute(builder: (_) => const UserFormScreen()),
          );

          if (nuevoUsuario != null && nuevoUsuario is User) {
            viewModel.agregarUsuario(nuevoUsuario);
          }
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}
