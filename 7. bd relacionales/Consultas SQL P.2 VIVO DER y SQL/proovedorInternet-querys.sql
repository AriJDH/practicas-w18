
  -- Query para crear la tabla de Clientes
CREATE TABLE `empresa_internet`.`clientes` (
  `id_clientes` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `fecha_de_nacimiento` DATE NOT NULL,
  `provincia` VARCHAR(100) NOT NULL,
  `ciudad` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_clientes`));
  
  -- Query para agregar 10 registros a la tabla Clientes
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (23765345, "Jorge", "Gomez", "1980-5-23", "Cordoba", "Alberdi");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (35968482, "Emilia", "Ramirez", "1988-5-23", "Mendoza", "Maipú");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (28349532, "Esteban", "Perez", "1990-5-23", "Gran Buenos Aires", "Lujan");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (33945945, "Rocio", "Berti", "2000-5-23", "Cordoba", "Toledo");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (33958473, "Juan", "Paso", "1998-5-23", "Mendoza", "Jocoli");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (29383726, "Lucia", "Gandulfo", "1995-5-23", "San Luis", "La Nelida");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (30273742, "Santiago", "Valdiz", "1997-5-23", "Santa Cruz", "Rio Gallegos");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (40237145, "Sol", "Hadda", "2001-5-23", "Gran Buenos Aires", "Campana");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (27349472, "Nicolas", "Sanabria", "1970-5-23", "Gran Buenos Aires", "Adrogue");
INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad) VALUES (28125393, "Florencia", "Diaz", "1975-5-23", "Tierra del Fuego", "Rio Grande");
  
  -- Query para crear la tabla de Planes de Internet
  CREATE TABLE `empresa_internet`.`planes_internet` (
  `id_plan` INT NOT NULL AUTO_INCREMENT,
  `plan` VARCHAR(100) NOT NULL,
  `velocidad` INT NOT NULL,
  `precio` INT NOT NULL,
  `descuento` INT NOT NULL,
  PRIMARY KEY (`id_plan`));
  
  -- Query para agregar 5 registros a la tabla Planes de Internet
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Basico 5MB", 50, 2000, 0);
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Estandar 50MB", 500, 3000, 15);
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Avanced 100MB", 1000, 3800, 25);
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Full 200MB", 2000, 4500, 35);
INSERT INTO planes_internet (plan, velocidad, precio, descuento) VALUES ("Plan Full Ejecutivo 500MB", 50000, 7000, 50);
  
  
