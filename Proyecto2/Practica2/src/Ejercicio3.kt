open class Shape {
    open fun calcularArea(): Double {
        return 0.0
    }

    open fun calcularPerimetro(): Double {
        return 0.0
    }

    fun impResultado() {
        println("Area: ${calcularArea()}")
        println("Perimetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(val lado: Double) : Shape() {
    override fun calcularArea(): Double = lado * lado
    override fun calcularPerimetro(): Double = 4 * lado
}

class Circulo(val radio: Double) : Shape() {
    override fun calcularArea(): Double = 3.14 * radio * radio
    override fun calcularPerimetro(): Double = 2 * 3.14 * radio
}

class Rectangulo(val ancho: Double, val alto: Double) : Shape() {
    override fun calcularArea(): Double = ancho * alto
    override fun calcularPerimetro(): Double = 2 * (ancho + alto)
}

fun main() {
    print("Ingrese el lado del cuadrado: ")
    val ladoCuadrado = readLine()?.toDoubleOrNull() ?: 0.0
    val cuadrado = Cuadrado(ladoCuadrado)
    println("\nCuadrado:")
    cuadrado.impResultado()

    print("\nIngrese el radio del circulo: ")
    val radioCirculo = readLine()?.toDoubleOrNull() ?: 0.0
    val circulo = Circulo(radioCirculo)
    println("\nCirculo:")
    circulo.impResultado()

    print("\nIngrese el ancho del rectangulo: ")
    val anchoRectangulo = readLine()?.toDoubleOrNull() ?: 0.0
    print("Ingrese el alto del rectangulo: ")
    val altoRectangulo = readLine()?.toDoubleOrNull() ?: 0.0
    val rectangulo = Rectangulo(anchoRectangulo, altoRectangulo)
    println("\nRectangulo:")
    rectangulo.impResultado()
}