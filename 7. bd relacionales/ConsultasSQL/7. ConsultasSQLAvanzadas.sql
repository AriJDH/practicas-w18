
USE biblioteca_db;

-- 1. Listar los datos de los autores.
SELECT 
    *
FROM
    autor;

-- 2. Listar nombre y edad de los estudiantes
SELECT 
    e.nombre, e.edad
FROM
    estudiante e;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT 
    e.nombre, e.carrera
FROM
    estudiante e
WHERE
    e.carrera LIKE 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT 
    a.nombre, a.nacionalidad
FROM
    autor a
WHERE
    a.nacionalidad LIKE 'Francesa'
        OR a.nacionalidad LIKE 'Italiana';

-- 5. ¿Qué libros no son del área de internet?
SELECT 
    titulo, area
FROM
    libro
WHERE
    NOT area LIKE 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT 
    titulo, editorial
FROM
    libro
WHERE
    editorial LIKE 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.

SELECT 
    e.nombre, e.edad
FROM
    estudiante e
WHERE
    e.edad > (SELECT 
            AVG(e1.edad)
        FROM
            estudiante e1);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT 
    nombre, apellido
FROM
    estudiante
WHERE
    apellido LIKE 'G%';

-- 9.  Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT 
    a.nombre
FROM
    autor a
        INNER JOIN
    libro_autor la ON a.id = la.id_autor
        INNER JOIN
    libro l ON la.id_libro = la.id_libro
WHERE
    l.titulo LIKE 'El Universo: Guía de viaje'
GROUP BY a.nombre;

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT 
    l.titulo
FROM
    libro l
       INNER JOIN
    prestamo p ON p.id_libro = l.id
       INNER JOIN
    estudiante e ON e.id = p.id_lector
WHERE
    e.nombre = 'Filippo'
        AND e.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT 
    e.nombre, e.edad
FROM
    estudiante e
ORDER BY e.edad ASC
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT 
    e.nombre
FROM
    libro l
        INNER JOIN
    prestamo p ON p.id_libro = l.id
        INNER JOIN
    estudiante e ON e.id = p.id_lector
WHERE
    l.area = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT 
    l.titulo
FROM
    autor a
        INNER JOIN
    libro_autor la ON la.id_autor = a.id
        INNER JOIN
    libro l ON la.id_libro = l.id
WHERE
    a.nombre = 'J.K. Rowling.';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT 
    l.titulo
FROM
    libro l
        INNER JOIN
    prestamo p ON p.id_libro = l.id
WHERE
    p.fecha_devolucion = '2022/10/10'
        AND p.devuelto = FALSE;

