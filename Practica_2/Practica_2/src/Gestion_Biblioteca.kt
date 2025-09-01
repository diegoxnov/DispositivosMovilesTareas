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
    fun RegistrarMat(eleccion: Int)
    fun RegistrarUsuario()
    fun PrestamoLibro()
    fun PrestamoRevista()
    fun Devolucion()
    fun MostrarMaterialesDisponibles()
    fun MostrarMaterialesReservados()
}

class Biblioteca(): ibiblioteca  {

    private val listaDeLibro = mutableListOf<libro>()
    private val listaDeLibroDisponibles = mutableListOf<libro>()
    private val listaDeLibroPrestado = mutableListOf<libro>()
    private val listaDeLibroRevista = mutableListOf<Revista>()
    private val listaDeRevistaDisponibles = mutableListOf<Revista>()
    private val listaDeRevistaPrestado = mutableListOf<Revista>()
    private val listaDeUsuarios = mutableListOf<Usuario>()
    private val registroPrestamos = mutableMapOf<Material,Usuario>()


    override fun RegistrarMat(eleccion: Int){

        when (eleccion){
            1 -> {
                println("Resgistrar Libro")
                println("Introduce el titulo: ")
                val titulo = readLine() ?: "sin titulo"
                println("Introduce el autor")
                val autor = readLine() ?: "sin autor"
                println("Introduce anio publicacion")
                val anioPublicacion = readLine() ?: "sin Anio Publicacion"
                println("Introduce genero")
                val genero = readLine() ?: "sin genero"
                println("Introduce numero pag")
                val numeroPag = readln().toIntOrNull() ?: 0

                val nuevoLibro = libro(genero, numeroPag, titulo, autor, anioPublicacion)
                listaDeLibro.add(nuevoLibro)
                listaDeLibroDisponibles.add(nuevoLibro)
                println("Libro: $titulo Registrado")

            }
            2 -> {
                println("Registrar Revista")
                println("Introduce el título: ")
                val titulo = readln()
                println("Introduce el autor/colaborador: ")
                val autor = readln()
                println("Introduce el año de publicación: ")
                val anio = readln()
                println("Introduce el ISSN: ")
                val issn = readln()
                println("Introduce el volumen: ")
                val volumen = readln()
                println("Introduce el número de la revista: ")
                val numero = readln().toIntOrNull() ?: 0
                println("Introduce la editorial: ")
                val editorial = readln()

                val nuevaRevis = Revista(issn, volumen, numero, editorial, autor, anio, titulo)

                listaDeLibroRevista.add(nuevaRevis)
                listaDeRevistaDisponibles.add(nuevaRevis)
                println("Revista: $titulo Registrado")
            }
            else -> {
                println("Opcion no vlida")
            }
        }

    }
    override fun RegistrarUsuario(){
        println("Registrar Usuarios")
        println("Introduce el Nombre: ")
        val nombre = readln()
        println("Introduce el Apellido ")
        val apellido = readln()
        println("Introduce la edad ")
        val anio = readln().toIntOrNull() ?: 0

        val nuevoUser = Usuario(nombre,apellido, anio)
        listaDeUsuarios.add(nuevoUser)
        println("Registro de usuario extiso")

    }
    override fun PrestamoLibro(){
        var usuario: Usuario
        var lbro: libro
        if(listaDeLibroDisponibles.isEmpty() || listaDeUsuarios.isEmpty()){
            println("usuarios y lista de libros vacio")
        } else{

            println("Escoge uno de los usuarios")
            listaDeUsuarios.forEachIndexed {
                index, x ->
                println("$index -> ${x.nombre} ${x.apellido}")
            }

            var x = readLine()?.toIntOrNull() ?: 0
            if(x in listaDeUsuarios.indices){
                usuario = listaDeUsuarios[x]
            }else{
                println("usuario escogido no existe")
                return
            }

            listaDeLibroDisponibles.forEachIndexed {
                index, x ->
                println("$index -> ${x.titulo}")
            }
            var y = readLine()?.toIntOrNull() ?: 0
            if(y in listaDeLibroDisponibles.indices){
                lbro = listaDeLibroDisponibles[y]
            }else{
                println("libro escogido no existe")
                return
            }

            listaDeLibroDisponibles.remove(lbro)
            listaDeLibroPrestado.add(lbro)
            registroPrestamos[lbro] = usuario
            println("se presto el libro: ${lbro.titulo} a ${registroPrestamos[lbro]?.nombre}")
        }
    }

    override fun PrestamoRevista() {
        var usuario: Usuario
        var revista: Revista
        if(listaDeRevistaDisponibles.isEmpty() || listaDeUsuarios.isEmpty()){
            println("usuarios y lista de revista vacios")
        } else{

            println("Escoge uno de los usuarios")
            listaDeUsuarios.forEachIndexed {
                    index, x ->
                println("$index -> ${x.nombre} ${x.apellido}")
            }

            var x = readLine()?.toIntOrNull() ?: 0
            if(x in listaDeUsuarios.indices){
                usuario = listaDeUsuarios[x]
            }else{
                println("usuario escogido no existe")
                return
            }

            println("escoge una revista")
            listaDeRevistaDisponibles.forEachIndexed {
                    index, x ->
                println("$index -> ${x.titulo}")
            }
            var y = readLine()?.toIntOrNull() ?: 0
            if(y in listaDeRevistaDisponibles.indices){
                revista = listaDeRevistaDisponibles[y]
            }else{
                println("revista escogida no existe")
                return
            }

            listaDeRevistaDisponibles.remove(revista)
            listaDeRevistaPrestado.add(revista)
            registroPrestamos[revista] = usuario
            println("se presto la revista: ${revista.titulo} a ${registroPrestamos[revista]?.nombre}")
        }
    }

    override fun Devolucion(){

        println("Devolver")
        println("1. libro")
        println("2. revista")
        var eleccion = readLine()?.toIntOrNull() ?: 0
        when (eleccion) {
            1 ->{
                var lbro: libro
                if(listaDeLibroPrestado.isEmpty()){
                    println("Selecciona el libro")
                    listaDeLibroPrestado.forEachIndexed {
                            index, x ->
                        println("$index -> ${x.titulo}")
                    }
                    var x = readLine()?.toIntOrNull() ?: 0
                    if(x in listaDeLibroDisponibles.indices){
                        lbro = listaDeLibroDisponibles[x]

                        listaDeLibroPrestado.remove(lbro)
                        println("se devolvio el libro ${registroPrestamos[lbro]?.nombre}")
                        registroPrestamos.remove(lbro)
                        listaDeLibroDisponibles.add(lbro)
                    }else{
                        println("Opción no válida")
                    }
                }else{
                    println("No hay libros prestados")
                }

            }
            2 -> {
                println("Selecciona la revista")

            }
            else -> {
                println("opcion invalida")
            }
        }

    }
    override fun MostrarMaterialesDisponibles(){
        println("Estos son los libros y revistas disponibles")
        println("libros")
        listaDeLibroDisponibles.forEach {
            x ->
            println("${x.titulo} ${x.autor} ${x.genero}")
        }
    }
    override fun MostrarMaterialesReservados(){

    }
}

fun main(){
    println("Introduce Crear libro")
    var biblio = Biblioteca()
    biblio.RegistrarMat(1)
    biblio.RegistrarUsuario()
    biblio.MostrarMaterialesDisponibles()
    biblio.PrestamoLibro()
// FALTA PROBAR LA DEVCOLUCION SI FUNCIONA O NO
    biblio.RegistrarMat(2)
    biblio.RegistrarUsuario()
    biblio.PrestamoRevista()


}
