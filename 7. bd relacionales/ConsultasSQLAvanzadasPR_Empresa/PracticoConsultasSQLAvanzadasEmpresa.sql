USE empresa;

-- 1 Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e 
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

-- 2 Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto
FROM departamento d 
JOIN empleado e ON d.depto_nro = e.depto_nro
GROUP BY d.nombre_depto
HAVING COUNT(e.idEMPLEADO)>=5;

-- 3 Mostrar el nombre, salario y nombre del departamento de los empleados
-- que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.nombre, empleado.salario, departamento.nombre_depto
FROM empleado
JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = (SELECT puesto FROM empleado WHERE nombre='Mito' AND apellido='Barchuk' LIMIT 1);

-- 4 Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleado e
WHERE e.depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto = 'Contabilidad' LIMIT 1);

-- 5 Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario 
FROM empleado 
ORDER BY CAST(salario AS FLOAT) LIMIT 1;

-- 6 Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT * 
FROM empleado 
WHERE depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto = 'Ventas')
ORDER BY CAST(salario AS FLOAT) DESC LIMIT 1;