DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

DROP TABLE IF EXISTS libro;
CREATE TABLE `libro`(
`id_libro` int(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
`titulo` varchar(30),
`editorial` varchar(30),
`area` varchar(30)
);

INSERT INTO libro (titulo, editorial, area)
VALUES ("Harry Potter 1", "Salamandra", "internet"),
("Harry Potter 2", "Salamandra", "Un área"),
("Percy Jackson 1", "Salamandra", "Otro área"),
("El mejor libro", "Planeta", "internet"),
("El Universo: Guía de viaje", "Planeta", "lelele"),
("SQL for dummies", "Planeta", "Base de Datos");

DROP TABLE IF EXISTS autor;
CREATE TABLE `autor`(
`id_autor` int(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
`nombre` varchar(30),
`nacionalidad` varchar(30)
);

INSERT INTO autor (nombre, nacionalidad)
VALUES ("J.K. Rowling", "inglesa"),
("Rick Riordan", "francesa"),
("El mejor autor", "italiana");

DROP TABLE IF EXISTS libro_autor;
CREATE TABLE `libro_autor`(
`id_autor` int(10) UNSIGNED NOT NULL,
`id_libro` int(10) UNSIGNED NOT NULL,
CONSTRAINT `libro_autor_pk` PRIMARY KEY (`id_autor`, `id_libro`),
CONSTRAINT `autor_fk` FOREIGN KEY (`id_autor`) REFERENCES `autor`(`id_autor`),
CONSTRAINT `libro_fk` FOREIGN KEY (`id_libro`) REFERENCES `libro`(`id_libro`)
);

INSERT INTO libro_autor (id_autor, id_libro)
VALUES(1,1),
(1,2),
(2,3),
(3,4),
(3,5),
(2,5),
(3,6);

DROP TABLE IF EXISTS estudiante;
CREATE TABLE `estudiante`(
`id_lector` int(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
`nombre` varchar(30),
`apellido` varchar(30),
`direccion` varchar(30),
`carrera` varchar(30),
`edad` int(10)
);

INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad)
VALUES ("Marcos", "Infantino", "Calle 1234", "Informática", 23),
("Marcelo", "Infantino", "Av 9 de julio 100", "Arquitectura", 50),
("Filippo", "Galli", "Avenida Siempore Viva 1234", "Abogacía", 40),
("Enrique", "Rodriguez", "Condarco 56", "Contaduría", 33),
("Norberto", "Gimenez", "Lala 1234", "Informática", 30);

DROP TABLE IF EXISTS prestamo;
CREATE TABLE `prestamo`(
`id_lector` int(10) UNSIGNED NOT NULL,
`id_libro` int(10) UNSIGNED NOT NULL,
`fecha_prestamo` date,
`fecha_devolucion` date,
`devuelto` boolean,
CONSTRAINT `prestamo_pk` PRIMARY KEY (`id_lector`, `id_libro`),
CONSTRAINT `prestamo_estudiante_fk` FOREIGN KEY (`id_lector`) REFERENCES `estudiante`(`id_lector`),
CONSTRAINT `prestamo_libro_fk` FOREIGN KEY (`id_libro`) REFERENCES `libro`(`id_libro`)
);

INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES (1,1,"2021-07-10","2021-07-16",false),
(2,2,"2021-07-11","2021-07-16",false),
(3,3,"2021-07-12","2021-07-16",true),
(3,1,"2021-08-10","2021-10-16",false),
(3,2,"2021-11-10","2021-12-16",false),
(4,4,"2021-12-10","2021-12-16",true),
(5,5,"2022-07-10","2022-07-16",false),
(1,6,"2021-07-10","2021-07-16",true),
(2,6,"2020-07-10","2020-07-16",true),
(3,6,"2021-05-10","2021-06-16",false);

