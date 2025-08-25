import kotlin.Float

fun CalculoSalario(puntuacion: Float, salario: Float): Float {
    val dinero = salario * (puntuacion/10)
    return dinero
}

fun NivelRendimiento(puntuacion: Float): String {
    if (puntuacion >= 0 && puntuacion <= 3) {
        return "Inaceptable"
    } else if (puntuacion >= 4 && puntuacion <= 6) {
        return "Aceptable"
    } else if (puntuacion >= 7 && puntuacion <= 10) {
        return "Meritorio"
    } else {
        return "Puntuacion Invalida"
    }
}

fun main(){
    println("Bienvenido")
    println("Ingresa el salario del empleado")
    val salario = readLine()!!.toFloat()
    println("Ingresa la puntuación del empleado del 0 al 10")
    val puntuacion = readLine()!!.toFloat()
    if (puntuacion > 0 && puntuacion < 10) {
        val salarioTotal = CalculoSalario(puntuacion, salario)
        println("Salario inicial: $salario; puntuacion: $puntuacion; Dinero: ${CalculoSalario(puntuacion,salario)} Resultado del rendimiento: ${NivelRendimiento(puntuacion)} ")
    } else if (puntuacion < 0 || puntuacion > 10) {
        println("Puntuacion Invalida")
    }
}
