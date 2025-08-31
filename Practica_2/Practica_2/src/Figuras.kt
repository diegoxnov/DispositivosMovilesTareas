//Diego Nova Rosas
//Figuras
abstract class Figuras(){

    abstract val area: Float
    abstract val perimetro: Float

    fun imprimirResultados(){
        println("Imprimir resultados:")
        println("El area es: $area")
        println("Perimetro es: $perimetro")
    }
}

class Circulo(): Figuras(){

    var radio: Float = 0.0f

    constructor(radio: Float): this(){
        this.radio = radio
    }

    override val area: Float
        get() = radio * radio * 3.1415f
    override val perimetro: Float
        get() = 2 * radio * 3.1415f
}



fun main(){

    val circulo = Circulo(5f)
    circulo.imprimirResultados()

}