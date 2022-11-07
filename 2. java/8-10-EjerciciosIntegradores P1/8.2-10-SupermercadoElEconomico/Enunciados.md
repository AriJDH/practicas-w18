**Supermercado “El económico”**

Un supermercado desea implementar un sistema, que le permita almacenar los datos de sus clientes y distintas facturas de las compras que los mencionados realicen. Para esto,  necesita poder realizar operaciones de creación, consulta, eliminación o actualización de datos de  todos los clientes y sus respectivas facturas asociadas.

De cada cliente se registran: dni, nombre y apellido. Por otro lado, las facturas que se generan cuando un cliente hace una compra contienen a un cliente, una lista de ítems y el total de la compra. De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario.

Dada la complejidad que posee el sistema, el Project Manager que dirige el proyecto ha decidido realizarlo en dos sprints, donde cada uno de ellos tendrá como objetivo una entrega final de una serie de requerimientos.

**Parte I**

Se necesita:
- Crear el modelo de clases clases que conforman, una factura, los cuales son: Cliente, Item, Factura.
- Crear 3 clientes y guardarlos en una collection.
- Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
- Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
- Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la 
  lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
