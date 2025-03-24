import kotlin.random.Random

/*

    El programa usa "Random" para generar una de las opciones de la lista y compararla con la eleccion
    de el usuario.

    Autor: Luis Ampuero
    Fecha-creacion: 15/03/2025
    Ultima modificacion: 16/03/2025
*/

fun main() {
    val opciones = listOf("piedra", "papel", "tijera")
    val eleccion_aleatoria = opciones[Random.nextInt(opciones.size)]

    println("Elige entre: piedra, papel o tijera:")
    val eleccion_usuario = readln().lowercase()

    if (eleccion_usuario !in opciones) {
        println("Elige entre: piedra, papel o tijera.")
        return
    }

    println("Elegiste: $eleccion_usuario")
    println("La computadora eligio: $eleccion_aleatoria")

    when {
        eleccion_usuario == eleccion_aleatoria -> println("Empate")
        (eleccion_usuario == "piedra" && eleccion_aleatoria == "tijera") ||
                (eleccion_usuario == "papel" && eleccion_aleatoria == "piedra") ||
                (eleccion_usuario == "tijera" && eleccion_aleatoria == "papel") -> println("Ganaste")
        else -> println("Perdiste")
    }
}