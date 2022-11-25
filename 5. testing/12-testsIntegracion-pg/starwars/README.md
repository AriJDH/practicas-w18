# Práctica test unitarios
## Práctica individual

### Objetivo

El objetivo de este ejercicio es que podamos afianzar y practicar la implementación de test unitarios. Para esto se tomará como base el proyecto “StarWars” adjunto, completamente implementado, se deberán realizar las pruebas unitarias (Unit Test) para las capas de controladores, servicios y repositorios.

¿Are you ready?

### Descripción

Recapitulamos sobre la funcionalidad aplicada en el proyecto “StarWars”:

Se trata de una API que permite buscar por nombre o parte del mismo personajes de Star Wars. La misma recibe una palabra a buscar y retorna un listado de personajes que contengan esa palabra en su nombre.

Ejemplo:
* Si buscamos "Luke" → nos mostrará el personaje de "Luke Skywalker".
* Si buscamos "Darth" → nos mostrará el personaje de "Darth Vader" y "Darth Maul".

Esta aplicación utiliza el archivo starwars.json como base de datos.

### Ejercicio
Se solicita crear los test unitarios correspondientes para las capas de controladores, servicios y repositorios. Agregar los escenarios necesarios para obtener la mayor cobertura de código posible, comprobando que el comportamiento esperado de cada unidad se cumpla correctamente.

Las clases candidatas para ser testeadas unitariamente son las siguientes:

* FindController
* CharacterRepositoryImpl
* FindService

El mínimo de cobertura esperada por cada una de las clases nombradas es del 80%.

Se deben identificar las dependencias de cada clase y mockearlas en caso de ser necesario para poder testearlas unitariamente. 
