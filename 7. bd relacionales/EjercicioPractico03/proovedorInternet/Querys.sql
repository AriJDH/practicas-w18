/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE empresa_internet_db;

/*
	1. Seleccionamos todos los clientes de "Cordoba"
*/
SELECT clientes.nombre, clientes.apellido, clientes.provincia
FROM clientes
WHERE clientes.provincia = "Cordoba";

/*
	2. Seleccionamos todos los clientes que contrataron el plan mas caro
*/
SELECT clientes.nombre, clientes.apellido, planes_internet.plan AS plan_contratado
FROM clientes 
JOIN planes_clientes_relacion ON clientes.dni_cliente = planes_clientes_relacion.dni_cliente
JOIN planes_internet ON planes_internet.id_plan = planes_clientes_relacion.id_plan
WHERE planes_internet.precio = (SELECT MAX(planes_internet.precio) FROM planes_internet);

/*
	3. Seleccionamos los 2 planes mas vendidos
*/
SELECT planes_internet.plan , count(clientes.dni_cliente) as mas_vendidos
FROM planes_internet
JOIN planes_clientes_relacion ON planes_internet.id_plan = planes_clientes_relacion.id_plan
JOIN clientes ON clientes.dni_cliente = planes_clientes_relacion.dni_cliente
GROUP BY planes_internet.plan ORDER BY  mas_vendidos DESC
LIMIT 2;

/*
	4. Obtener los usuarios con fecha nacimiento mayor A
*/
SELECT CONCAT(nombre, " ", apellido) AS nombre_apellido 
FROM clientes 
WHERE fecha_de_nacimiento > "1999-05-20";

/*
	5. Obtener los planes de internet con descuentos mayor A
*/
SELECT plan, velocidad, precio, descuento 
FROM planes_internet 
WHERE descuento > "10";

/*
	6. Obtener los planes de internet sin descuentos
*/
SELECT plan, velocidad, precio, descuento 
FROM planes_internet 
WHERE descuento = "0";

/*
	7. Obtener los planes de internet con velocidad mayor A
*/
SELECT plan, velocidad, precio, descuento 
FROM planes_internet 
WHERE velocidad > 500;

/* 
	8. Selecciona todos los usuarios distintos que han adquirido un plan
*/
SELECT DISTINCT clientes.dni_cliente, nombre, apellido
FROM clientes
JOIN planes_clientes_relacion pcr ON pcr.dni_cliente = clientes.dni_cliente;

/*
	9. Selecciona todos los usuarios que tengan adquirido un plan con descuento
*/
SELECT clientes.*, pi.*
FROM clientes
JOIN planes_clientes_relacion pcr ON pcr.dni_cliente = clientes.dni_cliente
JOIN planes_internet pi ON pi.id_plan = pcr.id_plan
WHERE pi.descuento > 0;

/*
	10. Selecciona todos los usuarios que vivan en la ciudad de "Adrogue"
*/
SELECT *
FROM clientes
WHERE clientes.ciudad= "Adrogue";
