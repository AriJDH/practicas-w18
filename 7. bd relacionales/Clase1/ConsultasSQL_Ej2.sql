SELECT *
FROM cliente;

SELECT *
FROM plan_internet;

SELECT id_plan, precio
FROM plan_internet
WHERE precio > 80000;

SELECT dni, nombre, apellido
FROM cliente
WHERE nombre LIKE "j%";

SELECT dni, nombre, apellido
FROM cliente
WHERE id_plan = 2;

SELECT dni, nombre, apellido, fecha_nacimiento
FROM cliente
WHERE fecha_nacimiento BETWEEN 19920101 AND 19961231;

SELECT dni, nombre, apellido, ciudad
FROM cliente
WHERE ciudad = "eeee";

SELECT dni, nombre, apellido, ciudad
FROM cliente
WHERE ciudad = "dddd" AND nombre LIKE "%a%";

SELECT dni, nombre, apellido, ciudad
FROM cliente
WHERE ciudad = "dddd" AND nombre LIKE "%a%";

SELECT id_plan, velocidad
FROM plan_internet
WHERE velocidad BETWEEN 50 AND 100