-- 1
SELECT * FROM biblioteca_db.autores;

-- 2.
SELECT nombre,edad FROM biblioteca_db.estudiantes;

-- 3.
SELECT * FROM biblioteca_db.estudiantes
WHERE carrera = "Informática";

-- 4.
SELECT * FROM biblioteca_db.autores
WHERE nacionalidad = "Francesa" or nacionalidad = "Italiana";

-- 5.
SELECT * FROM biblioteca_db.libros
WHERE area <> "Internet";

-- 6.
SELECT * FROM biblioteca_db.libros
WHERE editorial = "Salamandra";

-- 7.
SELECT * FROM biblioteca_db.estudiantes
WHERE edad > (SELECT AVG(edad) FROM biblioteca_db.estudiantes);

-- 8.
SELECT * FROM biblioteca_db.estudiantes
WHERE LEFT(apellido,1) = "G";

-- 9.
SELECT A.nombre FROM biblioteca_db.libro_autor AS LA
INNER JOIN biblioteca_db.autores AS A ON A.id_autor = LA.id_autor
INNER JOIN biblioteca_db.libros AS L ON L.id_libro = LA.id_libro
WHERE L.titulo = "El Universo: Guía de viaje";

-- 10.
SELECT L.titulo FROM biblioteca_db.prestamos AS P
INNER JOIN biblioteca_db.estudiantes AS E ON E.id_lector = P.id_lector
INNER JOIN biblioteca_db.libros AS L ON L.id_libro = P.id_libro
WHERE (E.nombre + " " + E.apellido) = "Filippo Galli";

-- 11.
SELECT nombre FROM biblioteca_db.estudiantes 
WHERE edad < 18;

-- 12.
SELECT E.nombre FROM biblioteca_db.prestamos AS P
INNER JOIN biblioteca_db.estudiantes AS E ON E.id_lector = P.id_lector
INNER JOIN biblioteca_db.libros AS L ON L.id_libro = P.id_libro
WHERE L.area = "Base de Datos";

-- 13.
SELECT A.nombre FROM biblioteca_db.libro_autor AS LA
INNER JOIN biblioteca_db.autores AS A ON A.id_autor = LA.id_autor
INNER JOIN biblioteca_db.libros AS L ON L.id_libro = LA.id_libro
WHERE A.nombre like "%Rowling%";

-- 14.
SELECT L.titulo FROM biblioteca_db.prestamos AS P
INNER JOIN biblioteca_db.libros AS L ON L.id_libro = P.id_libro
WHERE P.fecha_devolucion = "2021-07-16";