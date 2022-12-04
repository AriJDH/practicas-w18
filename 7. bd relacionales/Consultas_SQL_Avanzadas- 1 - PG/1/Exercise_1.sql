


-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad 
FROM empleado e INNER JOIN departamento d on e.depto_nro = d.depto_nro

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(e.idEMPLEADO) AS cantidad_empleados 
FROM departamento d LEFT JOIN empleado e on d.depto_nro = e.depto_nro GROUP BY 1 HAVING cantidad_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT CONCAT(e.nombre, ' ', e.apellido) AS nombre_completo, e.salario, d.nombre_depto, e.puesto
FROM empleado e
         INNER JOIN departamento d on e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE CONCAT(nombre, ' ', apellido) = 'Mito Barchuk')

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* FROM empleado e INNER JOIN departamento d on e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY nombre ASC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre AS salario 
FROM empleado e INNER JOIN departamento d on e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = 'Ventas' ORDER BY salario ASC LIMIT 1

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre AS salario 
FROM empleado e INNER JOIN departamento d on e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = 'Ventas' ORDER BY salario DESC LIMIT 1
