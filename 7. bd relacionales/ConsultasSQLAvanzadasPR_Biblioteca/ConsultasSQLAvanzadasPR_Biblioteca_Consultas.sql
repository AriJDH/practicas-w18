USE biblioteca_pr_sql_ns;

-- 1 Listar los datos de los autores.
SELECT * FROM autor;

-- 2 Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

-- 3 ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Informática';

-- 4 ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

-- 5 ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area = 'Internet';

-- 6 Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';

-- 7 Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8 Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM estudiante WHERE apellido LIKE 'G%';

-- 9 Listar los autores del libro “Harry Potter I”. (Se debe listar solamente los nombres).
SELECT a.nombre 
FROM autor a 
JOIN libroautor la ON a.idAutor = la.idAutor 
JOIN libro l ON l.idLibro = la.idLibro 
WHERE l.titulo = 'Harry Potter I';

-- 10 ¿Qué libros se prestaron al lector “Nicolás Sánchez”?
SELECT *
FROM prestamo p
JOIN estudiante e ON e.idLector = p.idLector
JOIN libro l ON l.idLibro = p.idLibro
WHERE e.nombre = 'Nicolás' 
AND e.apellido = 'Sánchez';

-- 11 Listar el nombre del estudiante de menor edad.
SELECT nombre, edad FROM estudiante ORDER BY edad LIMIT 1;

-- 12 Listar nombres de los estudiantes a los que se prestaron libros de Fantasía.
SELECT e.nombre, e.apellido
FROM estudiante e
JOIN prestamo p ON p.idLector = e.idLector
JOIN libro l ON l.idLibro = p.idLibro
WHERE l.area = 'Fantasía';

-- 13 Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM libro l
JOIN libroautor la ON l.idLibro = la.idLibro
JOIN autor a ON a.idAutor = la.idAutor
WHERE a.nombre = 'JK Rowling';

-- 14 Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT *
FROM prestamo p
JOIN libro l ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = '2022-12-03';