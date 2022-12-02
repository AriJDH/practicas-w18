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
SELECT * FROM Estudiante WHERE Edad > AVG(Edad); #Probar
# Listar lso nombres de lso estudiantes cuyo apellido comience con la letra G
SELECT * FROM Estudiante WHERE Apellido LIKE "G%";
#9. Listar los autores del libro "el Universo: Guia de viaje".(Listar solo nombre)
SELECT Autor.Nombre FROM Autor INNER JOIN LibroAutor WHERE LibroAutor.Nombre = (SELECT Titulo FROM Libro WHERE Titulo = "El Universo: Guía de viaje");
#10. Que libros se prestaron al lector "Filippo Galli"?
SELECT Libro.* FROM Libro INNER JOIN Prestamo WHERE Prestamo.idLector = (SELECT idLector FROM Estudiante WHERE Nombre = "Filippo Galli");
#11. Listar el nombre deel estudiante menor de edad
SELECT Nombre FROM Estudiante ORDER BY Edad LIMIT 1;