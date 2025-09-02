// DIEGO NOVA
// GESTION DE BIBLIOTECA

abstract class Material(val titulo: String, val autor: String, val anioPublicacion: String){
    abstract fun mostrarDetalles() //clase abstracta para mostar los detlles
}

class libro(var genero: String, var numeroPag: Int, titulo: String,
            autor: String, anioPublicacion: String): Material(titulo, autor, anioPublicacion){

    override fun mostrarDetalles(){
        println("Detalles Libro")
        println("Titulo: $titulo - Autor: $autor - Anio: $anioPublicacion - genero: $genero - NPag: $numeroPag")

    }
}//clase exclusiva para guardar libros

class Revista(var issn: String, var volumen: String, var numero: Int
  , var editorial: String, autor: String, anioPublicacion: String, titulo: String): Material(titulo, autor, anioPublicacion){

    override fun mostrarDetalles(){
        println("Detalles Revista")
        println("issn: $issn - Autor: $autor - Numero: $numero")
        println("Volumen: $volumen - Editorial: $editorial")
    }

}//clase para revistas

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

    private val listaDeLibro = mutableListOf<libro>() //lista que tendra todos los libros existentes
    private val listaDeLibroDisponibles = mutableListOf<libro>() // lista de libro DISPONBIBLES
    private val listaDeLibroPrestado = mutableListOf<libro>() // Lista de libros prestados
    private val listaDeLibroRevista = mutableListOf<Revista>() // lsita de revistas
    private val listaDeRevistaDisponibles = mutableListOf<Revista>() //lista de revistas sin prestar
    private val listaDeRevistaPrestado = mutableListOf<Revista>() //lista de revistas prestadas
    private val listaDeUsuarios = mutableListOf<Usuario>() // lista de usuarios
    private val registroPrestamos = mutableMapOf<Material,Usuario>() //


    override fun RegistrarMat(eleccion: Int){

        when (eleccion){//1 para crear libro y 2 para revista
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
                listaDeLibro.add(nuevoLibro)//agregamos la lista de libros y a la listqa de libros disponibles
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

                listaDeLibroRevista.add(nuevaRevis)//agregar revista y revista a Disponibles
                listaDeRevistaDisponibles.add(nuevaRevis)
                println("Revista: $titulo Registrado")
            }
            else -> {
                println("Opcion no vlida")//validaciones en caso no escojan un valor requerido
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
        listaDeUsuarios.add(nuevoUser) //creacion del nuevo usuario
        println("Registro de usuario extiso")

    }
    override fun PrestamoLibro(){
        var usuario: Usuario
        var lbro: libro
        if(listaDeLibroDisponibles.isEmpty() || listaDeUsuarios.isEmpty()){//verificamos que existan libros y usuarios
            println("usuarios y lista de libros vacio")
        } else{

            println("Escoge uno de los usuarios")
            listaDeUsuarios.forEachIndexed {
                index, x ->
                println("$index -> ${x.nombre} ${x.apellido}")//el usuario que hara el prestamo del libro
            }

            var x = readLine()?.toIntOrNull() ?: 0
            if(x in listaDeUsuarios.indices){
                usuario = listaDeUsuarios[x]
            }else{
                println("usuario escogido no existe")//validacion en caso se seleccione un usuario no valido
                return
            }

            listaDeLibroDisponibles.forEachIndexed {//imprimimos toda la lisgta de libros disponiblers creado
                index, x ->
                println("$index -> ${x.titulo}")
            }
            var y = readLine()?.toIntOrNull() ?: 0//rescatamos la seleccion del usuario
            if(y in listaDeLibroDisponibles.indices){
                lbro = listaDeLibroDisponibles[y]//agregamos a la varialbe el objeto seleccionado
            }else{
                println("libro escogido no existe")
                return
            }

            listaDeLibroDisponibles.remove(lbro)//eliminamos el libro seleccionado de disponibles
            listaDeLibroPrestado.add(lbro)//agrgamos ese mismo objeto a prestado
            registroPrestamos[lbro] = usuario//creeamos el mapa para establecer la relacion entre material prestado y usuaruio
            println("se presto el libro: ${lbro.titulo} a ${registroPrestamos[lbro]?.nombre}")
        }
    }

    override fun PrestamoRevista() {
        var usuario: Usuario
        var revista: Revista
        if(listaDeRevistaDisponibles.isEmpty() || listaDeUsuarios.isEmpty()){//validacion de existencia de usuario y recvista
            println("usuarios y lista de revista vacios")
        } else{

            println("Escoge uno de los usuarios")
            listaDeUsuarios.forEachIndexed {//imprimimos las revistas
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
                println("revista escogida no existe")// validacion en caso de mala eleccion
                return
            }

            listaDeRevistaDisponibles.remove(revista)//eliminamos la revista de disponibles
            listaDeRevistaPrestado.add(revista)//agregamos a prestadoos
            registroPrestamos[revista] = usuario
            println("se presto la revista: ${revista.titulo} a ${registroPrestamos[revista]?.nombre}")
        }
    }

    override fun Devolucion(){

        println("Devolver")
        println("1. libro")
        println("2. revista")
        var eleccion = readLine()?.toIntOrNull() ?: 0
        when (eleccion) {//indicamos si devolveremos libro o revista
            1 ->{
                var lbro: libro
                if(!listaDeLibroPrestado.isEmpty()){//debe existir prestamos
                    println("Selecciona el libro")
                    listaDeLibroPrestado.forEachIndexed {//impresion de los prestados
                            index, x ->
                        println("$index -> ${x.titulo}")
                    }
                    var x = readLine()?.toIntOrNull() ?: 0
                    if(x in listaDeLibroPrestado.indices){//verificamos que la seleccion este dentro de las opciones
                        lbro = listaDeLibroPrestado[x]

                        listaDeLibroPrestado.remove(lbro)//eliminamos de la lista prestado el objeto seleccionado
                        println("se devolvio el libro ${registroPrestamos[lbro]?.nombre}")
                        registroPrestamos.remove(lbro)//de igual manera en el mapa
                        listaDeLibroDisponibles.add(lbro)//agrgamos el libnro a disponible
                    }else{
                        println("Opción no válida")
                    }
                }else{
                    println("No hay libros prestados")
                }

            }
            2 -> {
                println("Selecciona la revista")
                var revist: Revista
                if (!listaDeRevistaPrestado.isEmpty()){
                    println("Selecciona la revista")
                    listaDeRevistaPrestado.forEachIndexed {
                        index,x ->
                        println("$index -> ${x.titulo}")
                    }
                    var x = readLine()?.toIntOrNull() ?: 0
                    if(x in listaDeRevistaPrestado.indices){
                        revist = listaDeRevistaPrestado[x]
                        listaDeRevistaPrestado.remove(revist)
                        listaDeRevistaDisponibles.add(revist)
                        registroPrestamos.remove(revist)
                        println("Se devolvio el libro ${registroPrestamos[revist]?.nombre}")
                    }else{
                        println("Opvion no valida")
                    }
                }else{
                    println("No hay revistas prestadas")
                }
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
            println("${x.titulo} ${x.autor} ${x.genero}")//mostramos toda la lista de materiales disponibles
        }
        println("===Revistas====")
        listaDeRevistaDisponibles.forEach {
                x ->
            println("${x.titulo} ${x.autor} ${x.issn}")//mostramos toda la lista de materiales disponibles
        }
    }
    override fun MostrarMaterialesReservados(){
        println("=======Mostrar los materiales Prestados======")
        println("Libros")
        listaDeLibroPrestado.forEach {//mostramos matreriales prestados
            x ->
            println("${x.titulo} ${x.autor} ${x.genero}")
        }
        println("=====Revista======")
        listaDeRevistaPrestado.forEach {
                x ->
            println("${x.titulo} ${x.autor} ${x.issn}")
        }
        println("=====FIN DE MATS PRESTADOS=====")
    }
}

fun main(){
    println("Introduce Crear libro")
    var biblio = Biblioteca()
    println("=======Registrar materiales======")
    biblio.RegistrarMat(1)
    println("===================")
    println("=======RegistrarUsuario========")
    biblio.RegistrarUsuario()
    println("===================")
    println("=======Mostrar Materiales Disponibles=======")
    biblio.MostrarMaterialesDisponibles()
    println("================")
    biblio.PrestamoLibro()
    println("====mostrar libros disponibles=====")
    biblio.MostrarMaterialesReservados()
    println("====================")
    biblio.Devolucion()
    println("==================")
    println("========Mostrar materiales Reservados======")
    biblio.MostrarMaterialesReservados()
    println("==================")
    println("========Registrar Materiales Revista==========")
    biblio.RegistrarMat(2)
    println("Ingresa una segunda revista")
    biblio.RegistrarMat(2)
    println("===================")
    println("========Registrar Usuario===========")
    biblio.RegistrarUsuario()
    println("==================")
    biblio.MostrarMaterialesDisponibles()
    println("=========Prestar Revista=========")
    biblio.PrestamoRevista()
    println("==========")

}
