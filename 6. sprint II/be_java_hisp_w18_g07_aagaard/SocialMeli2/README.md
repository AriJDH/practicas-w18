# Bootcamp Backend Java Sprint Nº 2 - Testing
## Wave 18 - Grupo 07

### Requerimientos incrementales (Desarrollo INDIVIDUAL)

#### T-0009

**Situaciones de entrada:**
* Verificar que la creación de una publicación válida se realiza correctamente
* Verificar que la creación de una publicación invalida el resuelto correctamente (US-0005)

**Comportamiento Esperado:**
* Válida: Devuelve una respuesta con un status de OK
* Inválida: Devuelve una respuesta con un status de client error y un cuerpo especificando los objetos inválidos

### Bonus  (Desarrollo Individual EXTRA)

Se implementaron varias pruebas de integración adicionales para lograr un coverage de líneas de 79%:

#### T-0010 - Integration - User followed seller publications

Se verifica que la consulta de publicaciones realizada en las últimas dos semanas de todos los vendedores de un usuario devuelva un status de OK en el caso de que exista y un mensaje de error en el caso de que no exista el usuario.

#### T-0011 - Integration - User followed list

Se verifica que la consulta de la lista de usuarios a la que sigue un usuario devuelva un status de OK y el cuerpo apropiado en el caso de que exista el usuario.


