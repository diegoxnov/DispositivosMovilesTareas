import kotlin.math.atan

abstract class Material(val titulo: String, val autor: String, val anioPublicacion: String){
    abstract fun mostrarDetalles()
}

class libro(var genero: String, var numeroPag: Int, titulo: String,
            autor: String, anioPublicacion: String): Material(titulo, autor, anioPublicacion){

    override fun mostrarDetalles(){
        println("Detalles Libro")
        println("Titulo: $titulo - Autor: $autor - Anio: $anioPublicacion - genero: $genero - NPag: $numeroPag")

    }
}

class Revista(var issn: String, var volumen: String, var numero: Int
  , var editorial: String, autor: String, anioPublicacion: String, titulo: String): Material(titulo, autor, anioPublicacion){

    override fun mostrarDetalles(){
        println("Detalles Revista")
        println("issn: $issn - Autor: $autor - Numero: $numero")
        println("Volumen: $volumen - Editorial: $editorial")
    }

}

class Usuario(var nombre: String, var apellido: String, var edad: Int){

}

interface ibiblioteca{
    fun RegistrarMat()
    fun RegistrarUsuario()
    fun Prestamo()
    fun Devolucion()
    fun MostrarMaterialesDisponibles()
    fun MostrarMaterialesReservados()
}



fun main(){

}
