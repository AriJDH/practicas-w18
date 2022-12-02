/*1 Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
SELECT e.nombre, e.puesto, d.localidad 
from departamento_empleado.departamento d 
inner join departamento_empleado.empleado e on e.depto_nro = d.depto_nro
where e.puesto = 'Vendedor';

/*2 Visualizar los departamentos con más de cinco empleados*/
SELECT d.nombre_depto, count(e.cod_emp)
from departamento_empleado.departamento d 
inner join departamento_empleado.empleado e on e.depto_nro = d.depto_nro
GROUP BY d.nombre_depto HAVING count(e.cod_emp) > 1;

/*3 Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que 'Mito Barchuk' */
SELECT e.nombre, e.salario, d.nombre_depto
from departamento_empleado.departamento d 
inner join departamento_empleado.empleado e on e.depto_nro = d.depto_nro
where puesto = (select puesto from departamento_empleado.empleado where nombre = 'Mito' and apellido = 'Barchuk');

/*4 Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/
SELECT e.*
FROM departamento_empleado.departamento d 
inner join departamento_empleado.empleado e on e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad' order by e.nombre;

/*5 Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT nombre FROM departamento_empleado.empleado WHERE salario = (
SELECT min(e.salario) salario  
FROM departamento_empleado.empleado e);

/*6 Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
SELECT t.* FROM departamento_empleado.empleado t
WHERE salario = (SELECT max(e.salario) salario  
	FROM departamento_empleado.departamento d 
	INNER JOIN departamento_empleado.empleado e on e.depto_nro = d.depto_nro
	WHERE d.nombre_depto = 'Ventas');