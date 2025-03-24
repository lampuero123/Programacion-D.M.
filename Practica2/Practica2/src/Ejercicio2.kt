/*

    Programa de cuenta bancaria que permite retirar y mostrar el saldo actual,
    pero tiene un limite de retiro que se puede ajustar
    Autor: Luis Ampuero
    Fecha de creacion: 22/03/2025
    Ultima modificacion: 22/03/2025

*/

class Producto {
    var precio: Double = 0.0
        get() = field
        set(precioNuevo) {
            field = precioNuevo
        }

    var descuento: Double = 0.0
        get() = field
        set(Desc) {
            field = Desc
        }

    fun cprecioFinal(): Double {
        return precio - (precio * descuento / 100)
    }
}

fun main() {
    val producto = Producto()

    print("Ingrese el precio: ")
    producto.precio = readLine()?.toDoubleOrNull() ?: 0.0

    print("Ingrese el descuento: ")
    producto.descuento = readLine()?.toDoubleOrNull() ?: 0.0

    println("Precio: ${producto.precio}")
    println("Descuento aplicado: ${producto.descuento}%")
    println("Precio final: ${producto.cprecioFinal()}")
}