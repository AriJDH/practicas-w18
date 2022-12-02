SELECT * FROM clientes;

SELECT * FROM planes_internet;

SELECT * FROM clientes
WHERE provincia = 'Gran Buenos Aires';

SELECT nombre, apellido FROM clientes
WHERE nombre = 'esteban';

SELECT * FROM planes_internet
WHERE velocidad > 2000;

SELECT * FROM planes_internet
WHERE velocidad > 50;

SELECT * FROM planes_internet
WHERE precio = 3000;

SELECT id_plan FROM planes_internet;

SELECT AVG(precio) as PROMEDIO_PRECIO FROM planes_internet;

SELECT plan from planes_internet;