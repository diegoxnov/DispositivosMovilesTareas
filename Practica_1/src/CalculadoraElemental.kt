
fun Suma(): Double {
    var nSuma: MutableList<Double> = mutableListOf()

    println("Digite los numeros a sumar o coloque fin para terminar")
    var choice1: String? = null
    do{
        choice1 = readln()
        val valor = choice1?.toDoubleOrNull()
        if (valor != null) {
            nSuma.add(valor)
        } else if(choice1?.lowercase() != "fin") {
            println("Entrada inválida. ingrese un valor correcto")
        }
    }while(choice1?.lowercase() != "fin")
    return nSuma.sum()
}

fun Mult(): Double {
    var nMult: MutableList<Double> = mutableListOf()
    var resultado = 0.0
    println("Digite los numeros a multiplicar o coloque fin para terminar")
    var choice1: String? = null
    do{
        choice1 = readln()
        val valor = choice1?.toDoubleOrNull()
        if (valor != null) {
            nMult.add(valor)
        }else if(choice1?.lowercase() != "fin") {
            println("Entrada invalida. Ingrese un valor correcto")
        }
    }while (choice1?.lowercase() != "fin")
    for(a in nMult) {
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
                val total = Suma()
                println("Resultado: $total")
            }
            3 -> {
                val total = Mult()
                println("Resultado: $total")
            }
        }
    }while(choice)

}