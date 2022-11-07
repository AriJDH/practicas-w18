# Supermercado “El Económico”
## Práctica Integradora

### Supermercado

Luego de la primera entrega satisfactoria, el Project Manager en conjunto con un analista funcional recabaron nuevos requerimientos para llevar a cabo una segunda parte de desarrollo en un nuevo sprint. Éstos se citan a continuación:

#### Parte II

* Crear una nueva factura.
* Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
  * Será necesario validar si el cliente asociado a la factura se encuentra registrado en la collection de clientes. En caso de que no, el mismo deberá ser creado.
  * Será necesario crear una lista de items y asociarla a la factura creada.
  * El campo total de la factura es un campo calculado, por lo cual, para poder asignar este valor deberemos recorrer la lista de items y realizar las operaciones matemáticas necesarias para obtener el total.

#### Bonus

* Con la finalidad de optimizar el código, se requiere la creación de una interfaz “repository.CrudRepository” que sea capaz de contener, mediante genéricos, todos los métodos necesarios para realizar altas, bajas, modificaciones y consultas.
* Crear o utilizar las correspondientes clases que sean capaz de implementar los métodos de la interfaz creada en el punto anterior.
* Modificar el método main para que, en lugar de realizar todo el código de manera secuencial, se pueda modularizar mediante el llamado de métodos.

