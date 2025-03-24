fun main() {

/*

    El programa usa "readln" para que el usuario ingrese los datos a calcular.

    Autor: Luis Ampuero
    Fecha-creacion: 15/03/2025
    Ultima modificacion: 16/03/2025

*/

    var opcion: Int
    do {

        println("==== Menu ====")
        println("1: Suma")
        println("2: Resta")
        println("3: Multiplicacion")
        println("4: Division")
        println("5: Salir")

        opcion = readln().toIntOrNull() ?: 0

        if (opcion !in 1..5) {
            println("Elige una opcion del 1 al 5.")
            continue
        }

        if (opcion == 5) {
            println("Acabando el programa")
            break
        }

        println("Ingresa el primer numero:  ")
        val num1 = readln().toDoubleOrNull()
        println("Ingresa el segundo numero:  ")
        val num2 = readln().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            println("Numeros no invalidos, ingresa numeros correctos.")
            continue
        }

        when (opcion) {
            1 -> println("Resultado: ${num1 + num2}")
            2 -> println("Resultado: ${num1 - num2}")
            3 -> println("Resultado: ${num1 * num2}")
            4 -> {
                if (num2 == 0.0) {
                    println("Error.")
                } else {
                    println("Resultado: ${num1 / num2}")
                }
            }
        }
    } while (true)
}