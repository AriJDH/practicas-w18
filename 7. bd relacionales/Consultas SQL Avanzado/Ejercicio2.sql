/*Listar los datos de los autores.*/
SELECT * FROM Biblioteca.autor;
/*Listar nombre y edad de los estudiantes*/
SELECT nombre, edad FROM Biblioteca.estudiante;
/*¿Qué estudiantes pertenecen a la carrera informática?*/
SELECT * FROM Biblioteca.estudiante WHERE carrera = 'Informática';
/*¿Qué autores son de nacionalidad francesa o italiana?*/
SELECT * FROM Biblioteca.autor WHERE nacionalidad = 'Italiano';
/*¿Qué libros no son del área de internet?*/
SELECT * FROM Biblioteca.libro WHERE area != 'internet';
/*Listar los libros de la editorial Salamandra*/
SELECT * FROM Biblioteca.libro where editorial = 'Salamandra';
/*Listar los datos de los estudiantes cuya edad es mayor al promedio.*/
SELECT * FROM Biblioteca.estudiante
where edad > (SELECT AVG(edad) FROM Biblioteca.estudiante);
/*Listar los nombres de los estudiantes cuyo apellido comience con la letra G.*/
SELECT * FROM Biblioteca.estudiante WHERE lower(apellido) like 'g%';
/*Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).*/
SELECT a.nombre
FROM Biblioteca.libroautor lb
Inner join Biblioteca.autor a on a.idautor = lb.idautor
Inner join Biblioteca.libro l on l.idlibro = lb.idlibro
where l.titulo = 'El Universo: Guía de viaje';
/*¿Qué libros se prestaron al lector “Filippo Galli”?*/
SELECT l.titulo
FROM Biblioteca.prestamo p
Inner join Biblioteca.estudiante e on e.idlector = p.idlector
Inner join Biblioteca.libro l on l.idlibro = p.idlibro
Where e.nombre = 'Filippo Galli';
/*Listar el nombre del estudiante de menor edad.*/
SELECT e.nombre
FROM Biblioteca.estudiante e
WHERE e.edad < 18;
/*Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.*/
SELECT e.nombre 
FROM Biblioteca.prestamo p
Inner join Biblioteca.estudiante e on e.idlector = p.idlector
Inner join Biblioteca.libro l on l.idlibro = p.idlibro
Where p.fechaPrestamo < CURDATE() AND l.area = 'Base de Datos'; 
/*Listar los libros que pertenecen a la autora J.K. Rowling.*/
SELECT l.*
FROM Biblioteca.libroautor lb
Inner join Biblioteca.autor a on a.idautor = lb.idautor
Inner join Biblioteca.libro l on l.idlibro = lb.idlibro
where a.nombre = 'J.K. Rowling.';
/*Listar títulos de los libros que debían devolverse el 16/07/2021.*/
SELECT l.titulo 
FROM Biblioteca.prestamo p
Inner join Biblioteca.libro l on l.idlibro = p.idlibro
WHERE cast(p.fechadevolucion AS DATE) = '2021-07-16' AND Devuelto = 0;