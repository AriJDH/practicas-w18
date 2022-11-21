# DTO, ResponseEntity y repaso general
## Práctica integradora

### Objetivo
Afianzar los conocimientos vistos sobre DTO y ResponseEntity y repasar las anotaciones más usadas.

¿Are you ready?

### Ejercicio Personajes de Star Wars
Se necesita desarrollar un API para buscar por nombre o parte del mismo personajes de Star Wars. La misma va a recibir una palabra a buscar y retorna un listado de personajes que contengan esa palabra en su nombre.

Ejemplo:

* Si buscamos "Luke" ->  nos mostrará el personaje de "Luke Skywalker"
* Si buscamos "Darth" -> nos mostrará el personaje de "Darth Vader" y "Darth Maul".

Tendremos una sola entidad llamada Personaje, con los siguientes atributos:
* name
* height
* mass
* hairColor
* skinColor
* eyeColor
* birthYear
* gender
* homeworld
* species

Todos los atributos serán de tipo String, excepto height y mass que serán de tipo entero.

Del personaje, se desea ver todos los atributos menos hairColor, skinColor, eyeColor y birthYear.

_Nota: Por el momento no se utilizará ninguna conexión de base de datos, así que utilizaremos el archivo starwars.json como base de datos. Tratar de aplicar la arquitectura multicapa donde sea posible hacerlo._
