/*Traer todos los datos de la tabla clientes*/
SELECT * FROM empresa_internet.clientes;
/*Traer todos los datos de la tabla planes*/
SELECT * FROM empresa_internet.planes;
/*Traer todos los datos de la tabla clientes_planes*/
SELECT * FROM empresa_internet.clientes_planes;
/*Traer todos los planes con descuento*/
SELECT * FROM empresa_internet.planes WHERE descuento > 0;
/*Traer todos los planes con precio entre 0 y 200 mil pesos */
SELECT * FROM empresa_internet.planes WHERE precio BETWEEN 0 AND 200000;
/*Traer todos los planes con precio aplicando el descuento  */
SELECT plan_id, megas, precio, descuento, precio-(precio*descuento) as descuento_aplicado FROM empresa_internet.planes;
/*Traer todos los datos de la tabla clientes ordenado por nombre desc*/
SELECT * FROM empresa_internet.clientes order by nombre desc;
/*Traer todos los datos de la tabla clientes ordenado por nombre asc*/
SELECT * FROM empresa_internet.clientes order by nombre;
/*Traer todos los datos de la tabla clientes cuya provincia sea Antioquia*/
SELECT * FROM empresa_internet.clientes WHERE provincia = 'Antioquia';
/*Traer todos los datos de la tabla clientes que tengan mas de 23 años*/
SELECT * FROM empresa_internet.clientes WHERE YEAR(CURDATE())-YEAR(fecha_nacimiento) >= 23
