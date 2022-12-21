/*
Creamos la DDBB
*/
CREATE SCHEMA `empresa_internet_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;

/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE empresa_internet_db;

/*
	Query para crear la tabla de Clientes
*/
CREATE TABLE `empresa_internet_db`.`clientes` (
  `dni_cliente` INT NOT NULL UNIQUE,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `fecha_de_nacimiento` DATE NOT NULL,
  `provincia` VARCHAR(100) NOT NULL,
  `ciudad` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`dni_cliente`));

/*
	Query para agregar 10 registros a la tabla Clientes
*/
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (23765345, "Jorge", "Gomez", "1980-5-23", "Cordoba", "Alberdi");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (35968482, "Emilia", "Ramirez", "1988-5-23", "Mendoza", "Maipú");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (28349532, "Esteban", "Perez", "1990-5-23", "Gran Buenos Aires", "Lujan");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (33945945, "Rocio", "Berti", "2000-5-23", "Cordoba", "Toledo");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (33958473, "Juan", "Paso", "1998-5-23", "Mendoza", "Jocoli");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (29383726, "Lucia", "Gandulfo", "1995-5-23", "San Luis", "La Nelida");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (30273742, "Santiago", "Valdiz", "1997-5-23", "Santa Cruz", "Rio Gallegos");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (40237145, "Sol", "Hadda", "2001-5-23", "Gran Buenos Aires", "Campana");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (27349472, "Nicolas", "Sanabria", "1970-5-23", "Gran Buenos Aires", "Adrogue");
INSERT INTO clientes (dni_cliente, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (28125393, "Florencia", "Diaz", "1975-5-23", "Tierra del Fuego", "Rio Grande");

/*
	Query para crear la tabla de Planes de Internet
*/
CREATE TABLE `empresa_internet_db`.`planes_internet` (
  `id_plan` INT NOT NULL AUTO_INCREMENT,
  `plan` VARCHAR(100) NOT NULL,
  `velocidad` INT NOT NULL,
  `precio` INT NOT NULL,
  `descuento` INT NOT NULL,
  PRIMARY KEY (`id_plan`));

/*
	Query para agregar 5 registros a la tabla Planes de Internet
*/
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Basico 5MB", 50, 2000, 0);
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Estandar 50MB", 500, 3000, 15);
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Avanced 100MB", 1000, 3800, 25);
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Full 200MB", 2000, 4500, 35);
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Full Ejecutivo 500MB", 50000, 7000, 50);

/*  
	Query para crear la tabla intermedia entre Clientes y planes_internet
*/
CREATE TABLE `empresa_internet_db`.`planes_clientes_relacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni_cliente` int NOT NULL,
  `id_plan` INT NOT NULL,
  PRIMARY KEY (`id`),
      FOREIGN KEY (dni_cliente) REFERENCES clientes(dni_cliente),
      FOREIGN KEY (id_plan) REFERENCES planes_internet(id_plan)
  );

/*
	Query para establecer la relacion entre nuestros 10 clientes y los 5 planes disponibles
*/
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (23765345, 1);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (35968482, 4);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (28349532, 3);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (33945945, 1);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (33958473, 5);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (29383726, 1);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (30273742, 2);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (40237145, 4);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (27349472, 5);
INSERT INTO planes_clientes_relacion (dni_cliente, id_plan) VALUES (28125393, 2);
