/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE empresa_db;

/*
	1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
*/
SELECT empleado.nombre, empleado.puesto, departamento.localidad
FROM empleado JOIN departamento
ON empleado.depto_nro = departamento.depto_nro;

/*
	2. Visualizar los departamentos con más de cinco empleados.
	   SE INTRODUJO OTRA CANTIDAD DE EMPLEADOS PARA DEMOSTRAR FUNCIONALIDAD ! SINO DEVUELVE VACÍO !
*/
SELECT departamento.nombre_depto, COUNT(empleado.depto_nro) AS cantidad_empleados
FROM departamento JOIN empleado
ON departamento.depto_nro = empleado.depto_nro
GROUP BY departamento.nombre_depto HAVING cantidad_empleados > 2;

/*
	3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
       SE INTRODUJO OTRO NOMBRE PARA DEMOSTRAR FUNCIONALIDAD ! SINO DEVUELVE VACÍO !
*/
SELECT empleado.nombre, empleado.salario, departamento.nombre_depto
FROM empleado JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = (SELECT puesto 
						 FROM empleado 
						 WHERE empleado.nombre =  "Jonathan" AND empleado.apellido = "Aguilera")
AND empleado.nombre != "Jonathan" AND empleado.apellido != "Aguilera";

/*
	4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
*/
SELECT empleado.*
FROM empleado JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = "Contabilidad"
ORDER BY empleado.nombre ASC;

/*
	5. Mostrar el nombre del empleado que tiene el salario más bajo.
    
	   El campo "salario" estaba creado con tipo de dato VARCHAR lo que imposibilitaba
       un correcto ordenado. Se modifico a INT, a continuacion dejo la instruccion que se utilizó
       ALTER TABLE empleado MODIFY COLUMN salario INT(11);
*/
SELECT empleado.nombre
FROM empleado
ORDER BY empleado.salario ASC
LIMIT 1;

/*
	6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
*/
SELECT empleado.*
FROM empleado JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = "Ventas"
ORDER BY empleado.salario DESC
LIMIT 1;