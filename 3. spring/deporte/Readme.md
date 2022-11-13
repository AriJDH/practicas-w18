Ejercicio Deportistas
Hacer deporte es muy importante para la salud. Consideramos una persona deportista a aquella que realice algún tipo de actividad física de forma frecuente.
Para validar si una persona es deportista, se necesita una aplicación que permita relacionar dos entidades:

Persona, cuyos atributos serán:
Nombre
Apellido
Edad
Deporte, cuyos atributos serán:
Nombre
Nivel

Nuestra aplicación deberá contar con la siguiente funcionalidad:

Ver todos los deportes que tenemos cargados.
PATH: /findSports
Consultar si existe un deporte ingresando su nombre. De existir, se deberá mostrar el nivel del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.
PATH: /findSport/{name}
Visualizar a las personas deportistas. Queremos que se vea un listado con el nombre y el apellido de la persona y el nombre del deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado). Para este punto es importante valerse de un DTO.
PATH: /findSportsPersons

Nota: Por el momento no se utilizará ninguna base de datos, así que se manipulan los objetos en listas.