import 'package:flutter/material.dart';


class UserListScreen extends StatelessWidget {
  final String email;

  const UserListScreen({super.key, required this.email});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Bienvenido: $email'),//mostramos el ingreso
      ),

    );
  }
}
