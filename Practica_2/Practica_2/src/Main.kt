// Autor: Diego Nova
// Clase para cuenta Bancaria

class CuentaBancaria(var saldo:Float) {
    private val limite:Float = 3000.00f

    fun Retiro(monto:Float){
        if(saldo < monto){
            println("Monto Insuficiente")
        }else if(monto > limite){
            println("El saldo supera el límite")
        }else{
            saldo = saldo - monto
            println("Operación exitosa")
            println("Su saldo es de: $saldo")
        }

    }
}


fun main(){
    val persona = CuentaBancaria(5000f)
    persona.Retiro(3100f)
}