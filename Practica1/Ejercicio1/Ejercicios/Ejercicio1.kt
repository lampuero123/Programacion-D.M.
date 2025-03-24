import kotlin.random.Random
/*

    El programa nos permite ingresar un salario mensual usando "readln", y al momento de ingresar una puntuacion
    nos permite elegir o generar una aleatoria usando "Random".

    Autor: Luis Ampuero
    Fecha-creacion: 15/03/2025
    Ultima modificacion: 16/03/2025

 */
fun main() {

    println("Ingresa tu salario mensual:")
    val salario = readln().toDoubleOrNull()

    if (salario == null || salario <= 0) {
        println("Salario no válido, ingrese un número positivo.")
        return
    }

    println("¿Desea que la puntuacion sea aleatoria? (s/n)")
    val respuesta = readln().lowercase()

    val puntuacion: Int
    if (respuesta == "n") {

        println("Ingresa tu puntuación del 0 al 10:")
        puntuacion = readln().toIntOrNull() ?: 0
    } else {
        puntuacion = Random.nextInt(0, 11)
        println("Puntuación generada aleatoriamente: $puntuacion")
    }

    if (puntuacion !in 0..10) {
        println("Puntuación no válida, debe estar entre 0 y 10.")
        return
    }

    val dinero_recibido = salario * (puntuacion / 10.0)
    val nivel_rendimiento = when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Desconocido"
    }

    println("\nResultados: ")
    println("Nivel de Rendimiento: $nivel_rendimiento")
    println("Cantidad de Dinero Recibido: $${"%.2f".format(dinero_recibido)}")
}