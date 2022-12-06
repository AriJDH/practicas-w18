/* GRUPO 2
-- Martin Aagaard
-- Sebastian Gines
-- Daniel Cagliari
-- Julian David Rincon Castro
-- Agustina Leonela Orozco
 */ 


/* 1 Listar los datos de los autores. */
select *
from Autor;

/* 2 Listar nombre y edad de los estudiantes */
select nombre, edad
from Estudiante;

/* 3 ¿Qué estudiantes pertenecen a la carrera informática?  */
select *
from Estudiante
where carrera = "Informatica";

/* 4 ¿Qué autores son de nacionalidad francesa o italiana? */
select *
from Autor
where nacionalidad in ("francesa", "italiana");

/* 5 ¿Qué libros no son del área de internet? */
select *
from Libro
where area != "internet";

/* 6 Listar los libros de la editorial Salamandra. */
select *
from Libro
where editorial = "Salamandra";

/* 7 Listar los datos de los estudiantes cuya edad es mayor al promedio. */
explain select * from Estudiante
where edad > (select avg(edad) from Estudiante);

/* 8 Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */
select nombre
from Estudiante
where apellido like "G%";

/* 9 Listar los autores del libro “El Universo: Guía de viaje”. 
(Se debe listar solamente los nombres). */
select a.nombre
from Autor a
join LibroAutor la on la.idAutor=a.idAutor
join Libro l on la.idLibro=l.idLibro
where l.titulo="El Universo: Guía de viaje";

/* 10 ¿Qué libros se prestaron al lector “Filippo Galli”? */

select l.titulo
from Libro l
join Prestamo p on p.idLibro=l.idLibro
join Estudiante e on e.idLector=p.idLector
where e.nombre = "Filippo" and e.apellido = "Galli";

/* 11 Listar el nombre del estudiante de menor edad. */

select nombre
from Estudiante
order by edad asc
limit 1;

/* 12 Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */

select e.nombre
from Libro l
join Prestamo p on p.idLibro=l.idLibro
join Estudiante e on e.idLector=p.idLector
where l.area = "Base de Datos";

/* 13 Listar los libros que pertenecen a la autora J.K. Rowling. */

select l.titulo
from Autor a
join LibroAutor la on la.idAutor=a.idAutor
join Libro l on la.idLibro=l.idLibro
where a.nombre="J.K. Rowling.";

/* 14 Listar títulos de los libros que debían devolverse el 16/07/2021. */

select l.titulo
from Libro l
join Prestamo p on p.idLibro=l.idLibro
where p.FechaDevolucion = "2021-07-16" and p.devuelto = False;

/* EJERCICIO 2 */

insert into Estudiante (Nombre, Apellido, Direccion, Carrera, Edad)  values("Martin", "Aagaard", "Calle 1 444", "Informática", 25);
insert into Estudiante (Nombre, Apellido, Direccion, Carrera, Edad) values("Julian David", "Rincon", "Calle 2 888", "Informática", 27);
insert into Estudiante (Nombre, Apellido, Direccion, Carrera, Edad) values("Daniel Alberto", "Cagliari", "Calle 3 999", "Informática", 28);
insert into Estudiante (Nombre, Apellido, Direccion, Carrera, Edad) values("Sebastián", "Gines", "Calle 3 555", "Programación", 30);
insert into Estudiante (Nombre, Apellido, Direccion, Carrera, Edad) values("Ariel", "Jaime", "Calle 10 888", "Magistratura", 31);

insert into Autor (Nombre, Nacionalidad) values
("J.K. Rowling", "inglesa"), 
("Pepiñe", "francesa"), ("Pepinato", "italiana"), 
("Pepez", "argentina"), ("Pepinho", "brasilera");

insert into LibroAutor values
(1, 1), (2, 1), 
(2, 5), (3, 1), 
(4, 2), (5, 3);

insert into Prestamo (idLector, idLibro, FechaDevolucion, Devuelto) values
(6, 1, "2021-07-16", false),
(1, 2,  "2021-07-16", false),
(2, 3,  "2022-02-10", false),
(6, 2, "2022-03-11", false),
(4, 4, "2022-04-01", false);

insert into Libro (Titulo, Editorial, Area) values
("Libro gordo", "Salamandra", "internet" ), 
("El Universo: Guía de viaje", "Salamandra", "matemática" ), 
("BD principiantes", "Salamandra"," Base de Datos" ), 
("BD avanzado", "Santillana","Base de Datos" ), 
("El internet de las cosas", "Salamandra","internet");

