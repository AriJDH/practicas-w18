DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

DROP TABLE IF EXISTS plan_internet;
CREATE TABLE `plan_internet`(
`plan_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
`velocidad` INT(10),
`precio` FLOAT,
`descuento` FLOAT
);

DROP TABLE IF EXISTS cliente;
CREATE TABLE `cliente`(
`cliente_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
`nombre` VARCHAR(30),
`apellido` VARCHAR(30),
`fecha_nacimiento` DATE,
`provincia` VARCHAR(30),
`ciudad` VARCHAR(30),
`plan_id` INT(10) UNSIGNED,
CONSTRAINT `cliente_fk` FOREIGN KEY (`plan_id`) REFERENCES `plan_internet`(`plan_id`)
);

INSERT INTO plan_internet (velocidad, precio, descuento)
VALUES(10, 100, 0),
(25, 250, 10),
(50, 500, 5),
(100, 1000, 15),
(200, 2000, 7);

INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad, plan_id)
VALUES ("Marcos", "Infantino", "1999-11-23", "Buenos Aires", "Wilde", 1),
("Rodrigo", "Rodriguez", "1990-12-03", "Buenos Aires", "Nordelta", 2),
("Juan", "Alvarez", "1989-11-23", "Salta", "Salta", 3),
("Marcelo", "Arboiro", "1979-09-22", "Buenos Aires", "CABA", 1),
("Marcela", "Juarez", "1980-09-21", "Cordoba", "Carlos Paz", 4),
("Enrique", "Juan", "1969-11-25", "Buenos Aires", "Avellaneda", 2),
("Roberto", "Roberto", "1967-02-03", "Tucuman", "Ciudad de Tucuman", 5),
("Jualian", "Damian", "1999-06-13", "Buenos Aires", "La Matanza", 1),
("Marco", "Polo", "1949-05-23", "Buenos Aires", "Wilde", 1),
("Homero", "Simpson", "1999-12-23", "Buenos Aires", "Wilde", 3);


