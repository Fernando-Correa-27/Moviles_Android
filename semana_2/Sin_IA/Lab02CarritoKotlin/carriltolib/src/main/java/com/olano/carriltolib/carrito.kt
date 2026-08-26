package com.correa.lab02carritokotlin

data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
)

fun calcularSubtotal(productos: List<Producto>): Double {
    var subtotal = 0.0
    for (p in productos) {
        subtotal += p.precio * p.cantidad
    }
    return subtotal
}

fun calcularIGV(subtotal: Double): Double {
    return subtotal * 0.18
}

fun calcularTotal(subtotal: Double, igv: Double): Double {
    return subtotal + igv
}

fun mostrarDetalle(productos: List<Producto>) {
    println("--------- DETALLE DEL CARRITO ---------")
    var i = 1

    for (p in productos) {
        val importe = p.precio * p.cantidad
        println(
            String.format(
                "%d. %-20s x%d S/ %8.2f",
                i,
                p.nombre,
                p.cantidad,
                importe
            )
        )
        i++
    }

    println("----------------------------------------")
}

fun calcularDescuento(total: Double): Double {
    return when {
        total > 5000 -> total * 0.10
        total > 3000 -> total * 0.05
        else -> 0.0
    }
}

fun buscarProducto(productos: List<Producto>, nombre: String): Producto? {
    return productos.find {
        it.nombre.equals(nombre, ignoreCase = true)
    }
}

fun main() {

    println("=========================================")
    println("   CARRITO DE COMPRAS - TIENDA TECSUP")
    println("=========================================")

    print("Ingrese nombre del cliente: ")
    val nombreCliente = readLine() ?: ""

    val carrito = mutableListOf<Producto>()

    println()
    println("Ingrese los productos")
    println("----------------------------------------")

    print("¿Cuántos productos desea agregar? ")
    val cantidadProductos = readLine()?.toIntOrNull() ?: 0

    for (i in 1..cantidadProductos) {

        println()
        println("Producto $i")

        print("Nombre del producto: ")
        val nombre = readLine() ?: ""

        print("Precio del producto: S/ ")
        val precio = readLine()?.toDoubleOrNull() ?: 0.0

        print("Cantidad: ")
        val cantidad = readLine()?.toIntOrNull() ?: 0

        val producto = Producto(nombre, precio, cantidad)

        carrito.add(producto)

        println("Producto agregado correctamente.")
    }

    println()
    println("Cliente: $nombreCliente")
    println()

    mostrarDetalle(carrito)

    println("Cantidad de productos : ${carrito.size}")

    val subtotal = calcularSubtotal(carrito)
    val igv = calcularIGV(subtotal)
    val total = calcularTotal(subtotal, igv)

    println(String.format("%-22s: S/ %8.2f", "Subtotal", subtotal))
    println(String.format("%-22s: S/ %8.2f", "IGV (18%)", igv))
    println(String.format("%-22s: S/ %8.2f", "TOTAL A PAGAR", total))
    println("----------------------------------------")

    val masCaro = carrito.maxByOrNull { it.precio }

    if (masCaro != null) {
        println(
            "Producto mas caro: ${masCaro.nombre} " +
                    String.format("(S/ %.2f)", masCaro.precio)
        )
    }

    val descuento = calcularDescuento(total)
    val totalConDescuento = total - descuento

    when {
        total > 5000 ->
            println("Descuento aplicado: 10% por compra mayor a S/ 5000")

        total > 3000 ->
            println("Descuento aplicado: 5% por compra mayor a S/ 3000")

        else ->
            println("Sin descuento aplicado (el total no supera S/ 3000)")
    }

    println(
        String.format(
            "%-22s: S/ %8.2f",
            "TOTAL CON DESCUENTO",
            totalConDescuento
        )
    )

    println()
    print("Ingrese un producto que desea buscar: ")
    val productoBuscado = readLine() ?: ""

    val encontrado = buscarProducto(carrito, productoBuscado)

    if (encontrado != null) {
        println(
            "Producto encontrado: ${encontrado.nombre} - " +
                    "S/ ${encontrado.precio}"
        )
    } else {
        println("Producto no encontrado")
    }

    println()
    print("Ingrese un producto que desea eliminar: ")
    val productoEliminar = readLine() ?: ""

    val eliminado = carrito.removeIf {
        it.nombre.equals(productoEliminar, ignoreCase = true)
    }

    if (eliminado) {
        println("Producto eliminado correctamente.")
    } else {
        println("Producto no encontrado.")
    }

    println()
    println("Carrito luego de eliminar:")
    mostrarDetalle(carrito)

    println()
    println("Gracias por su compra, $nombreCliente!")
}
