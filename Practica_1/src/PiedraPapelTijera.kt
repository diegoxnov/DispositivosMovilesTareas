

fun Aleatorio(): String {
    val juego = listOf("Piedra", "Papel", "Tijera")
    val juegoAleatorio = juego.random()
    return juegoAleatorio
}

fun Juego(choice: String, pc: String): String {
    if (choice == "Piedra" && pc == "Papel") {
        return "Gano pc"
    } else if (choice == "Piedra" && pc == "Piedra") {
        return "Empate!"
    } else if (choice == "Piedra" && pc == "Tijera") {
        return "Gana Usuario"
    } else if (choice == "Papel" && pc == "Tijera") {
        return "Gana pc"
    } else if (choice == "Papel" && pc == "Papel") {
        return "Empate!"
    } else if (choice == "Papel" && pc == "Piedra") {
        return "Gana Usuario"
    }else if (choice == "Tijera" && pc == "Tijera") {
        return "Empate!"
    } else if (choice == "Tijera" && pc == "Papel") {
        return "Gana Usuario"
    } else if (choice == "Tijera" && pc == "Piedra") {
        return "Gana pc"
    } else {
        return "movimiento invalido"
    }
}

fun Eleccion(Eleccion: Int): String {
    when (Eleccion) {
        1 -> return "Piedra"
        2 -> return "Papel"
        3 -> return "Tijera"
        else -> return "Escoge una opci[on correcta"
    }
}