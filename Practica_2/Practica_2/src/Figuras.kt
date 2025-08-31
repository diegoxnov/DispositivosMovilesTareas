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

class Cuadrado(): Figuras(){
    var lado: Float = 0.0f
    constructor(lado: Float): this(){
        this.lado = lado
    }
    override val area: Float
        get() = lado * lado
    override val perimetro: Float
        get() = lado * 4
}

class Rectangulo(): Figuras(){
    var altura: Float = 0.0f
    var base: Float = 0.0f
    constructor(altura: Float, base: Float): this(){
        this.altura = altura
        this.base = base
    }

    override val area: Float
        get() = base * altura
    override val perimetro: Float
        get() = 2 *(base+altura)
}

fun main(){

    println("Circulo: ")
    val circulo = Circulo(5f)
    circulo.imprimirResultados()

    println("Cuadrado: ")
    val cuadrado = Cuadrado(5f)
    cuadrado.imprimirResultados()


    println("Rectangulo: ")
    var rectangulo = Rectangulo(5f, 3f)
    rectangulo.imprimirResultados()

}