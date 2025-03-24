/*

    Programa de cuenta bancaria que permite retirar y mostrar el saldo actual,
    pero tiene un limite de retiro que se puede ajustar
    Autor: Luis Ampuero
    Fecha de creacion: 21/03/2025
    Ultima modificacion: 23/03/2025

*/
class CuentaBancaria {
    var saldo: Double = 0.0
        get() = field
        set(nm) {
            if (nm >= 0) {
                field = nm
            } else {
                println("Saldo invalido")
            }
        }

    var limiteRetiro: Double = 1000.0

    fun retirar(monto: Double) {
        when {
            monto > limiteRetiro -> println("El límite de retiro es de $limiteRetiro.")
            monto > saldo -> println("Saldo insuficiente, saldo actual: $saldo")
            else -> {
                saldo -= monto
                println("Retiro exitoso")
                println("Monto retirado: $monto. Saldo restante: $saldo")
            }
        }
    }
}

fun main() {

    val cuenta = CuentaBancaria()

    cuenta.saldo = 1500.0
    println("Saldo inicial: ${cuenta.saldo}")

    var opcion: Int

        println("Elija una opcion del 1 al 3:")
        println("1. Retirar dinero")
        println("2. Ver saldo")
        println("3. Salir")
        print("Seleccione una opcion: ")

        opcion = readLine()?.toIntOrNull() ?: 3

        when (opcion) {
            1 -> {
                print("Ingrese el monto a retirar: ")
                val monto = readLine()?.toDoubleOrNull()

                if (monto != null && monto > 0) {
                    cuenta.retirar(monto)
                } else {
                    println("Ingrese un monto valido")
                }
            }
            2 -> {
                println("Saldo actual: ${cuenta.saldo}")
            }
            3 -> {
                println("Saliendo")
            }
            else -> {
                println("Opcion no valida")
            }
        }

}