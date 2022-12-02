# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad 
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro  
WHERE d.depto_nro = 'D-000-4';
# Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, COUNT(*) as empleados_count
FROM departamento d 
INNER JOIN empleado e ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro 
HAVING empleados_count > 5;
# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto, e.puesto 
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (
	SELECT e2.puesto 
	FROM empleado e2 
	WHERE e2.nombre = 'Mito' AND e2.apellido = 'Barchuk'
);
# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.depto_nro = 'D-000-3'
ORDER BY e.nombre;
# Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre
FROM empleado e
ORDER BY CAST(e.salario as unsigned)
LIMIT 1;
# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro  
WHERE d.nombre_depto = 'Ventas'
ORDER BY CAST(e.salario as unsigned) DESC
LIMIT 1;
