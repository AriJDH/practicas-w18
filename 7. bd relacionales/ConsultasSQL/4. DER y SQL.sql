-- a. Se solicita crear una nueva base de datos llamada “empresa_internet”. 

CREATE DATABASE empresa_internet;

-- b. Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.

USE empresa_internet; 
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `dni` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `id_plan_internet` int DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente_UNIQUE` (`id_cliente`)
);

CREATE TABLE `plan_internet` (
  `id_plan_internet` int unsigned NOT NULL AUTO_INCREMENT,
  `megas_velocidad` double DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `descuento` double DEFAULT NULL,
  PRIMARY KEY (`id_plan_internet`)
);

INSERT INTO plan_internet VALUES(default, 10.00, 1000.00, 0.10);
INSERT INTO plan_internet VALUES(default, 20.00, 2000.00, 0.10);
INSERT INTO plan_internet VALUES(default, 30.00, 3000.00, 0.10);
INSERT INTO plan_internet VALUES(default, 40.00, 4000.00, 0.10);
INSERT INTO plan_internet VALUES(default, 50.00, 5000.00, 0.10);

INSERT INTO cliente VALUES(default, 12345678, "nombre1", "apellido1", "2002-10-02", "provincia", "ciudad", 1 );
INSERT INTO cliente VALUES(default, 12345678, "nombre2", "apellido2", "2002-10-02", "provincia", "ciudad", 2 );
INSERT INTO cliente VALUES(default, 12345678, "nombre3", "apellido3", "2002-10-02", "provincia", "ciudad", 3 );
INSERT INTO cliente VALUES(default, 12345678, "nombre4", "apellido4", "2002-10-02", "provincia", "ciudad", 4 );
INSERT INTO cliente VALUES(default, 12345678, "nombre5", "apellido5", "2002-10-02", "provincia", "ciudad", 5 );
INSERT INTO cliente VALUES(default, 12345678, "nombre6", "apellido6", "2002-10-02", "provincia", "ciudad", 1 );
INSERT INTO cliente VALUES(default, 12345678, "nombre7", "apellido7", "2002-10-02", "provincia", "ciudad", 2 );
INSERT INTO cliente VALUES(default, 12345678, "nombre8", "apellido8", "2002-10-02", "provincia", "ciudad", 3 );
INSERT INTO cliente VALUES(default, 12345678, "nombre9", "apellido9", "2002-10-02", "provincia", "ciudad", 4 );
INSERT INTO cliente VALUES(default, 12345678, "nombre10", "apellido10", "2002-10-02", "provincia", "ciudad", 5);

-- c. Realizar las asociaciones/relaciones correspondientes entre estos registros.
-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

SELECT * FROM cliente;
SELECT * FROM plan_internet;
SELECT c.nombre, c.id_plan_internet, pi.megas_velocidad
FROM cliente c
JOIN plan_internet pi
ON c.id_plan_internet = pi.id_plan_internet;

SELECT c.nombre, c.id_plan_internet, pi.precio
FROM cliente c
JOIN plan_internet pi
ON c.id_plan_internet = pi.id_plan_internet
WHERE pi.precio > 2000;

SELECT pi.megas_velocidad, COUNT(c.nombre)
FROM cliente c
JOIN plan_internet pi
ON c.id_plan_internet = pi.id_plan_internet
GROUP BY pi.megas_velocidad;