import 'package:flutter/material.dart';

class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Bienvenido"),// Título en la barra superior
      ),
      body: Center(
        // Centra el contenido en la pantalla
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,// Centra verticalmente
          children: [
            const Text(
              "¡Hola! Esta es mi aplicación personal",
              style: TextStyle(fontSize: 20),// Tamaño de letra más grande
            ),
            const SizedBox(height: 20),// Espacio entre elementos
            ElevatedButton(
              onPressed: () {},// Función vacía: sin acción aún
              child: const Text("Ver mi perfil"),
            ),
          ],
        ),
      ),
    );
  }
}
