
fun Suma(numero:List<Double>): Double {
    return numero.sum()
}

fun Mult(numero:List<Double>): Double {

    var resultado = 1.0
    for(a in numero) {
        resultado = a * resultado

    }

    return resultado
}

fun Rest(numero: Float, numero2: Float): Float {
    return numero - numero2
}

fun Div(numero: Int, numero2: Int): Float {
    return(numero/numero2).toFloat()
}

fun main(){

}