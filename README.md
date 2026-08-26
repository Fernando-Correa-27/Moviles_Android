¿por qué nombre y precio son val pero cantidad es var? ¿Qué
pasaría si intentas cambiar el precio después de crear el producto?

Respuesta: nombre y precio son val porque un producto una vez creado no debería cambiar sus valor. Además, estas variables no cambian a cada instante como es en el caso de cantidad, en su caso usamos var.  
Si intentas cambiar el precio el compilador te dará un error.
