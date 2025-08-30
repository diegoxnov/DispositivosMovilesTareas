// Autor: Diego Nova
// Desarrollo clase para Producto

class Producto(var precio:Float, var descuento: Int){
    fun CalculoDescuento():Float{
        var descuento2 = this.precio * (descuento)/100
        var precioFinal = this.precio - descuento2
        return precioFinal
    }
}

fun main(){
    val producto = Producto(100f,35)
    val precioTotal = producto.CalculoDescuento()
    println(precioTotal)
}

