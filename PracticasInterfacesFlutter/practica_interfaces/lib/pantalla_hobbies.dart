import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Mis Hobbies"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            hobbyItem(Icons.book, "Mirar películas de ficcion"),
            hobbyItem(Icons.videogame_asset, "Jugar videojuegos"),
            hobbyItem(Icons.music_note, "Escuchar mucha música"),
          ],
        ),
      ),
    );
  }

  Widget hobbyItem(IconData icono, String texto) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10),
      child: Row(
        children: [
          Icon(icono, size: 28),
          const SizedBox(width: 10),
          Text(texto, style: const TextStyle(fontSize: 18)),
        ],
      ),
    );
  }
}
