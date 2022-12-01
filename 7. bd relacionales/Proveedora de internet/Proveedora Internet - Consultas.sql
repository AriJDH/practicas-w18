USE empresa_internet;

#Consulta 1 - Obtener todos los clientes existentes 
SELECT * FROM cliente;
#Consulta 2 - Obtener todos los planes existentes
SELECT * FROM plan_internet;
#Consulta 3 - Obtener todos los clientes cuyo nombre empieze con "Mar"
SELECT * FROM cliente
WHERE nombre like "Mar%";
#Consulta 4 - Obtener la cantidad de suscripciones por plan 
SELECT plan_id, COUNT(*) AS cantidad_suscripciones from cliente 
GROUP BY plan_id;
#Consulta 5 - Obtener todos los clientes nacidos en septiembre
SELECT * FROM cliente
WHERE MONTH(fecha_nacimiento)=9;
#Consulta 6 - Obtener todos los clientes que posean el plan 1 
SELECT * FROM cliente
WHERE plan_id=1;
#Consulta 7 - Obtener todos los planes cuyo precio sea mayor a 100
SELECT * FROM plan_internet
WHERE precio>100;
#Consulta 8 - Obtener el precio final de todos los planes calculado a partir del descuento
SELECT plan_id, (precio*(1-descuento/100)) as precio_final FROM plan_internet;
#Consulta 9 - Obtener por cada plan, el nombre cliente con mayor edad
SELECT plan_id, (
SELECT CONCAT(nombre, " ", apellido) FROM cliente c
	WHERE c.plan_id=p.plan_id
    ORDER BY fecha_nacimiento
    LIMIT 1
) AS nombre_cliente_mayor_edad FROM plan_internet p;
#Consulta 10 - Obtener la cantidad de planes existentes
SELECT COUNT(plan_id) AS cantidad_planes FROM plan_internet
