# Listar los datos de los autores.
SELECT * FROM autor;

# Listar nombre y edad de los estudiantes
SELECT nombre,edad FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre,e.edad FROM estudiante e WHERE e.carrera = 'informatica';

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.nombre,a.nacionalidad FROM autor a WHERE a.nacionalidad IN ('italiano', 'frances');

# ¿Qué libros no son del área de internet?
SELECT titulo, area FROM libro WHERE area <> 'internet';

# Listar los libros de la editorial Salamandra.
SELECT titulo, area FROM libro WHERE editorial = 'Salamandra';


# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, edad FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido;
# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.*, l.titulo
FROM autor a
INNER JOIN libro_autor la on a.id_autor = la.id_autor
INNER JOIN libro l on la.id_libro = l.id_libro
WHERE l.titulo = 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo, a.nombre FROM libro l
LEFT JOIN libro_autor la on l.id_libro = la.id_libro
LEFT JOIN autor a on la.id_autor = a.id_autor
INNER JOIN prestamo p on l.id_libro = p.libro_id_libro
WHERE a.nombre = 'Filippo Galli';

# Listar el nombre del estudiante de menor edad.
SELECT nombre, edad
FROM estudiante
ORDER BY edad  ASC
LIMIT 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, l.titulo, l.area FROM estudiante e
LEFT JOIN prestamo p on e.id_lector = p.id_lector
INNER JOIN libro l on p.libro_id_libro = l.id_libro
WHERE l.area = 'Base de Datos';

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo, a.nombre FROM libro l
LEFT JOIN libro_autor la on l.id_libro = la.id_libro
INNER JOIN autor a on la.id_autor = a.id_autor
WHERE a.nombre = 'J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo, p.fecha_devolucion FROM libro l
LEFT JOIN prestamo AS p ON p.libro_id_libro AND l.id_libro
WHERE p.fecha_devolucion BETWEEN '2021-07-16 00:00:00' AND '2021-07-17 23:59:00'
GROUP BY 1,2;
