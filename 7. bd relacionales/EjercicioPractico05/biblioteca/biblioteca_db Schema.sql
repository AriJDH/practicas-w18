/*
Creamos la DDBB
*/
CREATE SCHEMA `biblioteca_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;

/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE biblioteca_db;

/*
	Query para crear la tabla Libro
*/
CREATE TABLE `biblioteca_db`.`libro` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(150) NULL,
  `editorial` VARCHAR(150) NULL,
  `area` VARCHAR(100) NULL,
  PRIMARY KEY (`id_libro`));

/*
	Query para crear la tabla Autor
*/
CREATE TABLE `biblioteca_db`.`autor` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  `apellido` VARCHAR(100) NULL,
  `nacionalidad` VARCHAR(100) NULL,
  PRIMARY KEY (`id_autor`));

/*
	Query para crear la tabla intermedia entre Libro y Autor
*/
CREATE TABLE `biblioteca_db`.`libro_autor` (
  `id_autor` int NOT NULL,
  `id_libro` INT NOT NULL,
      FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
      FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
  );

/*
	Query para crear la tabla Estudiante
*/
CREATE TABLE `biblioteca_db`.`estudiante` (
  `id_lector` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NULL,
  `apellido` VARCHAR(150) NULL,
  `direccion` VARCHAR(200) NULL,
  `carrera` VARCHAR(100) NULL,
  `edad` INT(5) NULL,
  PRIMARY KEY (`id_lector`));

/*
	Query para crear la tabla Prestamo
*/
CREATE TABLE `biblioteca_db`.`prestamo` (
  `id_lector` INT NOT NULL,
  `id_libro` INT NOT NULL,
  `fecha_prestamo` DATE NULL,
  `fecha_devolucion` DATE NULL,
  `devuelto` TINYINT NULL,
	FOREIGN KEY (id_lector) REFERENCES estudiante(id_lector),
	FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
  );

/*
	Query para llenar la tabla de autores
*/
INSERT INTO autor (id_autor, nombre, apellido, nacionalidad) VALUES (1, "J.K.", "Rowling", "Gran Bretaña");
INSERT INTO autor (id_autor, nombre, apellido, nacionalidad) VALUES (2, "Martin", "Fowler", "Gran Bretaña");
INSERT INTO autor (id_autor, nombre, apellido, nacionalidad) VALUES (3, "Antoine", "de Saint-Exupery", "Francia");
INSERT INTO autor (id_autor, nombre, apellido, nacionalidad) VALUES (4, "Oliver", "Berry", "Inglaterra");
INSERT INTO autor (id_autor, nombre, apellido, nacionalidad) VALUES (5, "Nicolas", "Maquiavelo", "Italia");
INSERT INTO autor (id_autor, nombre, apellido, nacionalidad) VALUES (6, "Valerie", "Stimac", "Canada");
INSERT INTO autor (id_autor, nombre, apellido, nacionalidad) VALUES (7, "Mark", "Garlick", "Inglaterra");

/*
	Query para llenar la tabla de libros
*/
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (1, "Harry Potter: Y la Piedra Filosofal", "Royal Edit", "Ciencia Ficcion");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (2, "Harry Potter: Y la Camara Secreta", "Leaf", "Ciencia Ficcion");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (3, "Harry Potter: Y el Caliz de Fuego", "Salamandra", "Ciencia Ficcion");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (4, "NoSQL Destiled", "Fake Editorial", "Base de Datos");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (5, "Refactoring I", "Fake Editorial", "Internet");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (6, "UML Destiled", "WiredSoft", "Base de Datos");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (7, "El Universo: Guia de Viaje", "GeoPlaneta", "Astrologia");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (8, "El Principito", "A-Z", "Literatura Infantil");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (9, "Tierra de los Hombres", "Apocriflies", "Biografia");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (10, "El Principe", "Centro Español", "Filosofia");
INSERT INTO libro (id_libro, titulo, editorial, area) VALUES (11, "Del Arte de la Guerra", "Salamandra", "Ciencia Ficcion");

/*
	Query para llenar la tabla de libro_autor
*/
INSERT INTO libro_autor (id_autor, id_libro) VALUES (1, 1);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (1, 2);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (1, 3);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (2, 4);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (2, 5);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (2, 6);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (3, 8);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (3, 9);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (5, 10);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (5, 11);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (4, 7);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (6, 7);
INSERT INTO libro_autor (id_autor, id_libro) VALUES (7, 7);

/*
	Query para llenar la tabla de estudiantes
*/
INSERT INTO estudiante (id_lector, nombre, apellido, direccion, carrera, edad) VALUES (1, "Juan", "Gomez", "Calle Falsa 123", "Informatica", 30);
INSERT INTO estudiante (id_lector, nombre, apellido, direccion, carrera, edad) VALUES (2, "Filippo", "Galli", "Siempre viva 2047", "Abogacia", 45);
INSERT INTO estudiante (id_lector, nombre, apellido, direccion, carrera, edad) VALUES (3, "Sofia", "Quiroz", "Munro 344", "Enfermerìa", 22);
INSERT INTO estudiante (id_lector, nombre, apellido, direccion, carrera, edad) VALUES (4, "Laura", "Muñoz", "Congreso 1101", "Mecanica", 30);
INSERT INTO estudiante (id_lector, nombre, apellido, direccion, carrera, edad) VALUES (5, "Florencia", "Diaz", "Av Libertador 230", "Filosofia", 70);

/*
	Query para llenar la tabla de prestamos
*/
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES (2, 1, "2019-1-16", "2019-02-16", true);
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES (1, 1, "2019-04-22", "2019-05-16", true);
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES (2, 5, "2020-07-07", "2020-07-16", false);
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES (3, 4, "2021-01-01", "2021-02-16", false);
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES (4, 4, "2021-07-09", "2021-07-16", false);
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES (5, 4, "2021-07-10", "2021-07-16", false);

