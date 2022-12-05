/* =========================================== */
-- Creación de Base de datos
/* =========================================== */

CREATE TABLE estudiante (
	idLector INT UNSIGNED NOT NULL,
	Nombre VARCHAR(45) NOT NULL,
	Apellido VARCHAR(45) NOT NULL,
	Direccion VARCHAR(45) NOT NULL,
	Carrera VARCHAR(45) NOT NULL,
	Edad INT UNSIGNED NOT NULL,
	PRIMARY KEY (IdLector)
);

CREATE TABLE libro (
	idLibro INT UNSIGNED NOT NULL,
	Titulo VARCHAR(45) NOT NULL,
	Editorial VARCHAR(45) NOT NULL,
	Area VARCHAR(45) NOT NULL,
	PRIMARY KEY (idLibro)
);

CREATE TABLE prestamo (
  idLector INT UNSIGNED NOT NULL,
  idLibro INT UNSIGNED NOT NULL,
  FechaPrestamo DATE NOT NULL,
  FechaDevolucion DATE,
  Devuelto BOOLEAN NOT NULL,
  FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
  FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

CREATE TABLE autor (
	idAutor INT UNSIGNED NOT NULL,
    Nombre VARCHAR(45) NOT NULL,
    Nacionalidad VARCHAR(45) NOT NULL,
	PRIMARY KEY (idAutor)
);

CREATE TABLE libroAutor (
  idLibro INT UNSIGNED NOT NULL,
  idAutor INT UNSIGNED NOT NULL,
  FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
  FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

/* =========================================== */
-- Datos de Base de datos
/* =========================================== */
insert into estudiante values(1, "Martin", "Aagaard", "Calle 1 444", "Informática", 25);
insert into estudiante values(2, "Julian David", "Rincon", "Calle 2 888", "Informática", 27);
insert into estudiante values(3, "Daniel Alberto", "Cagliari", "Calle 3 999", "Informática", 28);
insert into estudiante values(4, "Sebastián", "Gines", "Calle 3 555", "Programación", 30);
insert into estudiante values(5, "Ariel", "Jaime", "Calle 10 888", "Magistratura", 31);
insert into estudiante values(6, "Filippo", "Galli", "Calle 123", "Magistratura", 32);

insert into libro values(1, "Libro gordo", "Salamandra","internet" );
insert into libro values(2, "El Universo: Guía de viaje", "Salamandra","matemática" );
insert into libro values(3, "BD principiantes", "Salamandra","Base de Datos" );
insert into libro values(4, "BD avanzado", "Santillana","Base de Datos" );
insert into libro values(5, "El internet de las cosas", "Salamandra","internet" );

insert into autor values(1, "J.K. Rowling", "inglesa");
insert into autor values(2, "Pepiñe", "francesa");
insert into autor values(3, "Pepinato", "italiana");
insert into autor values(4, "Pepez", "argentina");
insert into autor values(5, "Pepinho", "brasilera");

insert into prestamo values(6, 1, "2021-07-01", "2021-07-16", false);
insert into prestamo values(1, 2, "2021-06-01", "2021-07-16", false);
insert into prestamo values(2, 3, "2022-01-01", "2022-02-10", false);
insert into prestamo values(6, 2, "2022-02-01", "2022-03-11", false);
insert into prestamo values(4, 4, "2022-02-01", "2022-04-01", false);

insert into libroAutor values(1,1);
insert into libroAutor values(2,1);
insert into libroAutor values(2,5);
insert into libroAutor values(3,1);
insert into libroAutor values(4,2);
insert into libroAutor values(5,3);

/* =========================================== */
-- Consultas de Base de datos
/* =========================================== */
-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select e.nombre, e.apellido from estudiante e;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante 
where carrera = "informática";

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor
where Nacionalidad in ("francesa", "italiana");

-- ¿Qué libros no son del área de internet?
select * from libro
where Area != "internet";

-- Listar los libros de la editorial Salamandra.
select * from libro
where Editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante
where edad > (select avg(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select e.nombre from estudiante e
where e.apellido like "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.Nombre from autor a
inner join libroAutor la on la.idAutor = a.idAutor
inner join libro l on l.idLibro = la.idLibro
where l.Titulo = "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.Titulo from libro l 
inner join prestamo p on p.idLibro = l.idLibro
inner join estudiante e on e.idLector = p.idLector
where e.Nombre = "Filippo" and e.Apellido = "Galli";

-- Listar el nombre del estudiante de menor edad.
select Nombre from estudiante
order by edad
limit 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.Nombre from estudiante e
inner join prestamo p on p.idLector = e.idLector
inner join libro l on l.idLibro = p.idLibro
where l.Area = "Base de Datos";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.* from libro l
inner join libroAutor la on la.idLibro = l.idLibro
inner join autor a on a.idAutor = la.idAutor
where a.Nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.Titulo from libro l
inner join prestamo p on p.idLibro = l.idLibro
where p.FechaDevolucion = "2021-07-16" and p.devuelto = false;




