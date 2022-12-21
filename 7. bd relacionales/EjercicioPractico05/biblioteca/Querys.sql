/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE biblioteca_db;

/*
	1. Listar los datos de los autores.
*/
SELECT *
FROM autor;

/*
	2. Listar nombre y edad de los estudiantes
*/
SELECT estudiante.nombre, estudiante.edad
FROM estudiante;

/*
	3. ¿Qué estudiantes pertenecen a la carrera informática?
*/
SELECT *
FROM estudiante
WHERE carrera = "Informatica";

/*
	4. ¿Qué autores son de nacionalidad francesa o italiana?
*/
SELECT *
FROM autor
WHERE nacionalidad = "Francia" OR nacionalidad = "Italia";

/*
	5. ¿Qué libros no son del área de internet?
*/
SELECT *
FROM libro
WHERE area != "Internet";

/*
	6. Listar los libros de la editorial Salamandra.
*/
SELECT *
FROM libro
WHERE editorial = "Salamandra";

/*
	7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
*/
SELECT *
FROM estudiante
WHERE estudiante.edad > (SELECT AVG(estudiante.edad) AS promedio
						 FROM estudiante);

/*
	8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
*/
SELECT estudiante.nombre
FROM estudiante
WHERE estudiante.apellido LIKE "G%";

/*
	9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
*/
SELECT autor.nombre
FROM autor 
JOIN libro_autor ON autor.id_autor = libro_autor.id_autor
JOIN libro ON libro_autor.id_libro = libro.id_libro
WHERE libro.titulo = "El Universo: Guía de viaje";

/*
	10. ¿Qué libros se prestaron al lector “Filippo Galli”?
*/
SELECT libro.*
FROM libro
JOIN prestamo ON libro.id_libro = prestamo.id_libro
JOIN estudiante ON prestamo.id_lector = estudiante.id_lector
WHERE estudiante.nombre = "Filippo" AND estudiante.apellido = "Galli";

/*
	11. Listar el nombre del estudiante de menor edad.
*/
SELECT *
FROM estudiante
ORDER BY estudiante.edad ASC
LIMIT 1;

/*
	12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
*/
SELECT estudiante.nombre
FROM estudiante
JOIN prestamo ON estudiante.id_lector = prestamo.id_lector
JOIN libro ON prestamo.id_libro = libro.id_libro
WHERE libro.area = "Base de Datos";

/*
	13. Listar los libros que pertenecen a la autora J.K. Rowling.
*/
SELECT *
FROM libro
JOIN libro_autor ON libro.id_libro = libro_autor.id_libro
JOIN autor ON libro_autor.id_autor = autor.id_autor
WHERE autor.nombre = "J.K." AND autor.apellido = "Rowling";

/*
	14. Listar títulos de los libros que debían devolverse el 16/07/2021.
*/
SELECT libro.titulo
FROM libro
JOIN prestamo ON libro.id_libro = prestamo.id_libro
WHERE prestamo.fecha_devolucion = "2021-07-16";