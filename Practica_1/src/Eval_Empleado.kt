fun CalculoSalario(puntuacion: Int, salario: Float): Float {
    val dinero = salario * (puntuacion/10)
    return dinero
}

fun NivelRendimiento(puntuacion: Int): String {
    if (puntuacion > 0 && puntuacion < 6) {
        return "Inaceptable"
    } else if (puntuacion > 5 && puntuacion < 7) {
        return "Aceptable"
    } else if (puntuacion > 6 && puntuacion < 11) {
        return "Meritorio"
    } else {
        return "Puntuacion Invalida"
    }
}


