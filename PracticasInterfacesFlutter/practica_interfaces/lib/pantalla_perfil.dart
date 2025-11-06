import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Mi Perfil"),// Título de la pantalla
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0), // Espacio alrededor del contenido
        child: Column(
          children: [
            // Imagen de internet
            Image.network(
              "https://i.pravatar.cc/200",
              width: 150, // Ancho de la imagen
              height: 150, // Alto de la imagen
            ),

            const SizedBox(height: 20),// Espacio entre widgets

            const Text(
              "Diego Nova",
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),// Texto más grande y negrita
            ),

            const SizedBox(height: 10),

            const Text(
              "Estudiante de Ingeniería de Software / Interesado en tecnología y desarrollo",
              textAlign: TextAlign.center,// Alinear el texto al centro
            ),

            const SizedBox(height: 20),

            Row(
              mainAxisAlignment: MainAxisAlignment.center, // Centrar la fila
              children: const [
                Icon(Icons.email),// Icono de correo
                SizedBox(width: 10),// Espacio entre icono y texto
                Text("diegonova@gmail.com"),// Texto del correo
              ],
            ),
          ],
        ),
      ),
    );
  }
}
