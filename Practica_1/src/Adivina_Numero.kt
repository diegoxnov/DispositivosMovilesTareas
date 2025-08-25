
fun main() {
    // Genera un número aleatorio entre 1 y 30.
    val numeroAleatorio = (1..30).random()
    var intentosRestantes = 5

    println("Adivina el numero")
    println("tiene 5 intentes adivine el numero entre 1 y 30")

    while (intentosRestantes > 0) {
        println("\nIntentos restantes: $intentosRestantes")
        print("Ingresa tu suposición: ")

        val entrada = readLine()
        val suposicion = entrada?.toIntOrNull()

        if (suposicion == null) {
            println("Entrada inválida. Por favor, ingresa un número.")
            continue
        }

        if (suposicion == numeroAleatorio) {
            println("\n número correcto: $numeroAleatorio")
            return
        } else if (suposicion < numeroAleatorio) {
            println("El número que busco es mayor que $suposicion.")
        } else {
            println("El número que busco es menor que $suposicion.")
        }

        intentosRestantes--
    }

    println("\nGame Over.")
    println("El número secreto era: $numeroAleatorio")
}