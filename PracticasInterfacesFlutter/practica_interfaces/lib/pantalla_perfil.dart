import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Mi Perfil"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          children: [
            // Imagen de internet
            Image.network(
              "https://i.pravatar.cc/200",
              width: 150,
              height: 150,
            ),

            const SizedBox(height: 20),

            const Text(
              "Diego Nova",
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),

            const SizedBox(height: 10),

            const Text(
              "Estudiante de Ingeniería de Software / Interesado en tecnología y desarrollo",
              textAlign: TextAlign.center,
            ),

            const SizedBox(height: 20),

            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(Icons.email),
                SizedBox(width: 10),
                Text("diegonova@gmail.com"),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
