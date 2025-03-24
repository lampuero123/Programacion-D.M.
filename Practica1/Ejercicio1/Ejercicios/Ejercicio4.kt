import kotlin.random.Random
/*

    El programa usa "Random" para generar un numero aleatorio, y el usuario tiene que adivinar el numero.

    Autor: Luis Ampuero
    Fecha-creacion: 16/03/2025
    Ultima modificacion: 16/03/2025

*/
fun main() {

    val numero = Random.nextInt(1, 31)
    var intentos = 5
    var adivinado = false

    println("Adivina el numero entre el 1 y 30. Tienes 5 intentos.")

    while (intentos > 0 && !adivinado) {
        println("\nIntentos restantes: $intentos")
        println("Ingresa un numero:   ")
        val numero_usuario = readln().toIntOrNull()

        if (numero_usuario == null || numero_usuario !in 1..30) {
            println("Ingresa un numero entre 1 y 30.")
            continue
        }

        when {
            numero_usuario == numero -> {
                println("Adivinaste el numero: $numero")
                adivinado = true
            }
            numero_usuario < numero -> println("El numero es mayor que $numero_usuario.")
            else -> println("El numero es menor que $numero_usuario.")
        }
        intentos--
    }

    if (!adivinado) {
        println("\nEl número era: $numero")
    }
}