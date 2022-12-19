-- 1- Listar los datos de los autores.
SELECT * FROM autor;

-- 2- Listar nombre y edad de los estudiantes
SELECT nombre, apellido, edad from estudiante;

-- 3- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante
WHERE carrera = 'Informatica';

-- 4- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad = 'Francia' OR nacionalidad = 'Italia';

-- 5- ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area != 'Internet';

-- 6- Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';

-- 7- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT avg(edad) FROM estudiante);

-- 8- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido LIKE 'G%';

-- 9- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre, l.titulo
FROM autor a
INNER JOIN libroAutor la
ON a.idautor = la.autor_idAutor
INNER JOIN libro l on l.idlibro = la.libro_idlibro
WHERE l.titulo = 'El Universo: Guía de viaje';

-- 10- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT * FROM libro l
INNER JOIN prestamo p
ON l.idlibro = p.libro_idLibro
INNER JOIN estudiante e
ON e.idestudiante = p.estudiante_idestudiante
WHERE concat(e.nombre, ' ', e.apellido) = 'Filipo Galli';

-- 11- Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante
WHERE edad = (SELECT min(edad) FROM estudiante);

-- 12- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT nombre FROM estudiante e
INNER JOIN prestamo p ON e.idEstudiante = p.estudiante_idestudiante
INNER JOIN libro l ON l.idlibro = p.libro_idlibro
WHERE l.area = 'Base de Datos';

-- 13- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * FROM libros l
INNER JOIN libroAutor la ON l.idlibro = la.libro_idLibro
INNER JOIN autor a ON a.idautor = la.autor_idautor
WHERE a.nombre = 'J. K. Rowling';

-- 14- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM libro l
INNER JOIN prestamo p ON l.idlibro = p.libro_idLibro
WHERE p.fechaDevolucion = '2021-07-16';

