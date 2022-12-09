# 1. Listar los datos de los autores
SELECT * FROM Autor;
# 2. Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM Estudiante;
# 3. Que estudiantes pertenecen a la carrera de informatica?
SELECT * FROM Estudiante WHERE Carrera = "Informatica";
# 4. Que autores son de nacionalidad francesa o italiana?
SELECT * FROM Autor WHERE Nacionalidad IN ("Francesa","Italiana");
# 5. Que libros no son del area de internet?
SELECT * FROM Libro WHERE Area != "Internet";
# 6. Listar los libros de la editorial salamandra
SELECT * FROM Libro WHERE Editorial = "Salamandra";
# Listar los datos de los estudiantes cuya edad es mayor al promedio
SELECT * FROM Estudiante WHERE Edad > (SELECT AVG(edad) FROM Estudiante);
# Listar los nombres de los estudiantes cuyo apellido comience con la letra G
SELECT * FROM Estudiante WHERE Apellido LIKE "G%";
#9. Listar los autores del libro "el Universo: Guia de viaje".(Listar solo nombre)
SELECT * FROM Autor INNER JOIN Libro_Autor ON Autor.idAutor = Libro_Autor.idAutor WHERE Libro_Autor.idLibro = (SELECT idLibro FROM Libro WHERE Titulo = "El Universo:Guia de viaje");
#10. Que libros se prestaron al lector "Filippo Galli"?
SELECT Libro.* FROM Libro INNER JOIN Prestamo ON Libro.idLibro = Prestamo.idLibro WHERE Prestamo.idLector = (SELECT idLector FROM Estudiante WHERE Nombre = "Filippo" AND Apellido = "Galli");
#11. Listar el nombre del estudiante menor de edad
SELECT Nombre FROM Estudiante ORDER BY Edad LIMIT 1;
#12. Listar nombres de los estudiantes a los que se prestaron libros de bases de datos
SELECT estudiante.nombre FROM prestamo INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector where idLibro = (Select idLibro From libro WHERE Area = "Base de datos");
#13. Listar los libros que pertenecen a la autora J.K. Rowling
SELECT libro.* FROM libro INNER JOIN libro_autor ON libro.idLibro = libro_autor.idLibro WHERE idAutor = (SELECT idAutor FROM autor WHERE nombre = "J.K. Rowling");
#14. Listar titulos de los libros que debian devolverse el 16/07/2021
SELECT libro.titulo FROM prestamo INNER JOIN libro ON prestamo.idLibro = libro.idLibro WHERE prestamo.FechaDevolucion = "2021-07-16";