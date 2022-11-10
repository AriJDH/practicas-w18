# POO 🚀


## Ejercicio 1


1. Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int. Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado”

2. Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje “No se puede dividir por cero”



## Ejercicio 2 
Debemos entregar un trabajo para una distribuidora de productos, por lo que vamos a generar un programa que realice diferentes operaciones. Tendremos dos categorías de productos diferentes: Perecederos ecederoy No Pers.

1. Crear una clase Producto que cuente con los siguientes atributos: String nombre y double precio, la misma debe definir los métodos getters y setters para sus atributos, un constructor que reciba todos sus atributos como parámetro y el método toString(). Crear el método calcular() al cual vamos a pasarle un parámetro de tipo int llamado cantidadDeProductos; este método tiene que multiplicar el precio por la cantidad de productos pasados.

2. Crear la clase Perecedero, que va a tener un atributo llamado diasPorCaducar de tipo int, al igual que para el producto, definir setters, getters, constructor que reciba todos los atributos por parámetro y el método toString(). Esta clase debe heredar de Producto y sobreescribir el método calcular(), el cual tiene que hacer lo mismo que la clase Producto (multiplicar el precio por la cantidad de productos) y adicionalmente, reducir el precio según los diasPorCaducar:

