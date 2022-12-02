
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

-- PENDIENTE!! 

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE "G%";

-- 9.  Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
-- PENDIENTE!! 

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
-- PENDIENTE!! 

-- 11. Listar el nombre del estudiante de menor edad.
-- PENDIENTE!! 

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
-- PENDIENTE!! 

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
-- PENDIENTE!! 

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
-- PENDIENTE!! 
