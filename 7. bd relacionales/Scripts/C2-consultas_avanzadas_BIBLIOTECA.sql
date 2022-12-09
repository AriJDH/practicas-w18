
INSERT INTO `biblioteca`.`autor` (`nombre`) VALUES ('J. K. Rowling');
UPDATE `biblioteca`.`autor` SET `nacionalidad` = 'Argentina' WHERE (`id_autor` = '1');
INSERT INTO `biblioteca`.`autor` (`nombre`, `nacionalidad`) VALUES ('Jorge Luis Borges', 'Argentina');
INSERT INTO `biblioteca`.`autor` (`nombre`, `nacionalidad`) VALUES ('Roberto Arlt', 'Argentina');





# 1 Listar los datos de los autores.
SELECT * FROM biblioteca.autor;

# 2 Listar nombre y edad de los estudiantes
SELECT * FROM estudiante;
SELECT nombre, edad FROM estudiante;

# 3 ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'informática';

# 4 ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor;
SELECT * FROM autor WHERE nacionalidad in ('Francesa', 'Italiana'); 


# 5 ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area != 'internet';

# 6 Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';

# 7 Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);


# 8 Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

SELECT nombre, apellido FROM estudiante WHERE apellido LIKE 'G%';

# 9 Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT autor.nombre, libro.titulo
FROM libro
JOIN libro_has_autor
ON libro_has_autor.libro_id_libro = libro.id_libro
JOIN autor
ON autor.id_autor = libro_has_autor.autor_id_autor
WHERE libro.titulo LIKE '%El Universo: Guía de viaje';



# 10 ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT libro.titulo 
FROM libro 
WHERE id_libro = (
    SELECT libro_id_libro 
    FROM prestamo
    WHERE prestamo.estudiante_id_estudiante
        in (
        SELECT id_estudiante 
        FROM estudiante 
        WHERE concat(nombre, ' ', apellido) = 'Filippo Galli') );


# 11 Listar el nombre del estudiante de menor edad.
SELECT nombre, edad FROM estudiante ORDER BY edad ASC LIMIT 1;


# 12 Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT estudiante.nombre 
FROM estudiante
WHERE id_estudiante IN (
    SELECT estudiante_id_estudiante 
    FROM prestamo
    WHERE prestamo.libro_id_libro
        in (
        SELECT id_libro
        FROM libro 
        WHERE area = 'Base de Datos') );
        
        
# 13 Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT titulo FROM libro WHERE id_libro = (
    SELECT libro_id_libro FROM libro_has_autor WHERE autor_id_autor = (
        SELECT id_autor FROM autor where nombre LIKE '%Rowling'));



# 14 Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT * FROM libro WHERE id_libro IN (
SELECT libro_id_libro FROM prestamo WHERE fecha_devolucion = '2021-07-16');
