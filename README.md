# Carrito de compras en Kotlin: variables, funciones y operaciones

**Nombre Completo:** Fernando Luis Correa Huincho

**Descripción:** El programa simula el funcionamientos de un carrito de compras. Calcula automáticamente el subtotal, IGV y total a pagar. Además, aplica un descuento del 5% y 10% si el monto total supera 3000 o 5000 respectivamente. 

<img width="791" height="701" alt="Captura de pantalla 2026-08-26 031846" src="https://github.com/user-attachments/assets/5b6b4503-ace0-42a9-8477-bc80f269888c" />

***

### ¿por qué nombre y precio son val pero cantidad es var? ¿Qué pasaría si intentas cambiar el precio después de crear el producto?

**Respuesta:** nombre y precio son val porque un producto una vez creado no debería cambiar sus valor. Además, estas variables no cambian a cada instante como es en el caso de cantidad, en su caso usamos var.  

Si intentas cambiar el precio el compilador te dará un error.

***

**Prompt:**

Tengo el siguiente código en Kotlin de un carrito de compras (proyecto lab02carritokotlin para un curso en Tecsup). Actualmente está escrito de forma procedural: usa una data class Producto y funciones sueltas (calcularSubtotal, calcularIGV, calcularTotal, mostrarDetalle, calcularDescuento, buscarProducto) que reciben List<Producto> como parámetro, y en main() los datos del carrito están hardcodeados.

Quiero que lo reescribas aplicando dos mejoras:

Programación orientada a objetos real, no solo una data class con funciones externas:
Una clase Producto que encapsule su propio cálculo de importe (precio × cantidad).
Una clase Cliente.
Una clase Carrito que mantenga la lista de productos como estado privado y exponga métodos propios para agregar, eliminar, buscar productos, y calcular subtotal, IGV (18%), descuento (10% si el total > S/5000, 5% si > S/3000) y total.
Idealmente, separar la lógica de negocio (Carrito) de la interacción con el usuario (una clase de menú aparte), en vez de mezclarlo todo en main().

Interfaz interactiva por consola ("prompt"): en vez de precargar productos fijos en el código, quiero un menú que use readLine() para que el usuario pueda:
* Agregar un producto (nombre, precio, cantidad)
* Eliminar un producto por nombre
* Buscar un producto por nombre
* Ver el detalle del carrito con subtotal, IGV, descuento y total
* Salir

Incluye validación básica de datos (que precio y cantidad sean numéricos y positivos), y mantén el formato de salida con String.format como en el original (alineado, con "S/" como moneda). El paquete es com.correa.lab02carritokotlin.

Aquí está el código original:


