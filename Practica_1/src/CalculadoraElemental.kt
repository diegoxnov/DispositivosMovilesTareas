
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

    val choice: Boolean = true
    do{
        println("==Menu==")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicacion")
        println("4. Division")
        println("5. Salir")
        // 1. Leer la entrada de texto del usuario
        val input = readLine()
        // 2. Convertir la entrada a un Int de forma segura
        val numero: Int? = input?.toIntOrNull()
        when(numero) {
            1 ->{
                val nSuma: MutableList<Double> = mutableListOf()
                val nAdd: Double

                println("Digite los numeros a sumar o coloque fin para terminar")
                val choice1: String = "fin"
                while (choice1 != "fin") {
                    nAdd = readLine()!!.toDouble()
                    nSuma.add(nAdd)
                    if (choice1 == "fin"){
                        Suma(nSuma)
                    }
                }
            }
        }
    }while(choice)

}