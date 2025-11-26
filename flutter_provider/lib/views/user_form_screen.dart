import 'package:flutter/material.dart';
import '../models/user.dart';

class UserFormScreen extends StatefulWidget {
  final User? usuario;
  final int? indice;

  const UserFormScreen({super.key, this.usuario, this.indice});

  @override
  State<UserFormScreen> createState() => _UserFormScreenState();
}

class _UserFormScreenState extends State<UserFormScreen> {
  final _formKey = GlobalKey<FormState>();

  late String _nombre;
  String _genero = 'Masculino';
  bool _activo = true;
  late int _edad;
  late String _correo;

  @override
  void initState() {
    super.initState();

    if (widget.usuario != null) {
      _nombre = widget.usuario!.nombre;
      _genero = widget.usuario!.genero;
      _activo = widget.usuario!.activo;
      _edad = widget.usuario!.edad;
      _correo = widget.usuario!.correo;
    } else {
      _nombre = '';
      _edad = 0;
      _correo = '';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.usuario == null ? 'Agregar Usuario' : 'Editar Usuario'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: ListView(
            children: [
              TextFormField(
                initialValue: _nombre,
                decoration: const InputDecoration(labelText: 'Nombre'),
                validator: (value) =>
                value == null || value.isEmpty ? 'Ingrese un nombre válido' : null,
                onSaved: (value) => _nombre = value!,
              ),
              const SizedBox(height: 20),

              TextFormField(
                initialValue: _edad == 0 ? '' : _edad.toString(),
                decoration: const InputDecoration(labelText: 'Edad'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) return 'Ingrese la edad';
                  final n = int.tryParse(value);
                  if (n == null || n <= 0) return 'La edad debe ser mayor a 0';
                  return null;
                },
                onSaved: (value) => _edad = int.parse(value!),
              ),
              const SizedBox(height: 20),

              TextFormField(
                initialValue: _correo,
                decoration: const InputDecoration(labelText: 'Correo'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Ingrese un correo';
                  }
                  final emailRegex =
                  RegExp(r'^[\w\.-]+@[\w\.-]+\.\w+$');
                  if (!emailRegex.hasMatch(value)) {
                    return 'Correo inválido';
                  }
                  return null;
                },
                onSaved: (value) => _correo = value!,
              ),
              const SizedBox(height: 20),

              const Text('Género'),
              Row(
                children: [
                  Expanded(
                    child: RadioListTile(
                      title: const Text('Masculino'),
                      value: 'Masculino',
                      groupValue: _genero,
                      onChanged: (value) => setState(() => _genero = value!),
                    ),
                  ),
                  Expanded(
                    child: RadioListTile(
                      title: const Text('Femenino'),
                      value: 'Femenino',
                      groupValue: _genero,
                      onChanged: (value) => setState(() => _genero = value!),
                    ),
                  ),
                ],
              ),

              SwitchListTile(
                title: const Text('Activo'),
                value: _activo,
                onChanged: (value) => setState(() => _activo = value),
              ),
              const SizedBox(height: 30),

              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    _formKey.currentState!.save();

                    final user = User(
                      nombre: _nombre,
                      genero: _genero,
                      activo: _activo,
                      edad: _edad,
                      correo: _correo,
                    );

                    Navigator.pop(context, user);
                  }
                },
                child:
                Text(widget.usuario == null ? 'Guardar' : 'Actualizar'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
