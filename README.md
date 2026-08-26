Título: Carrito de compras en Kotlin: variables, funciones y operaciones
Nombre Completo: Fernando Luis Correa Huincho
Descripción: El programa simula el funcionamientos de un carrito de compras. Calcula automáticamente el subtotal, IGV y total a pagar. Además, aplica un descuento del 5% y 10% si el monto total supera 3000 o 5000 respectivamente. 

<img width="791" height="701" alt="Captura de pantalla 2026-08-26 031846" src="https://github.com/user-attachments/assets/5b6b4503-ace0-42a9-8477-bc80f269888c" />



¿por qué nombre y precio son val pero cantidad es var? ¿Qué
pasaría si intentas cambiar el precio después de crear el producto?

Respuesta: nombre y precio son val porque un producto una vez creado no debería cambiar sus valor. Además, estas variables no cambian a cada instante como es en el caso de cantidad, en su caso usamos var.  
Si intentas cambiar el precio el compilador te dará un error.
