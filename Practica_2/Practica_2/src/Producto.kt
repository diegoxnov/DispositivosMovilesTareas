// Autor: Diego Nova
// Desarrollo clase para Producto

class Producto(var precio:Float, var descuento: Int){
    val precioConDescuento: Float
        get() = precio - (precio * descuento/100)

}

fun main(){
    val producto = Producto(100f,35)
    println("El precio es ${producto.precio} y el precio con descuento es: ${producto.precioConDescuento}")
}

