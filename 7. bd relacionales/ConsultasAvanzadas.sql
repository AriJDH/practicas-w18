-- Consulta 1
SELECT e.nombre, e.puesto, d.localidad 
FROM empleado e INNER JOIN departamento d on e.depto_nro = d.depto_nro

-- Consulta 2  
SELECT d.nombre_depto, COUNT(e.idEMPLEADO) AS cantidad_empleados 
FROM departamento d LEFT JOIN empleado e on d.depto_nro = e.depto_nro GROUP BY 1 HAVING cantidad_empleados > 5;

-- Consulta 3
SELECT CONCAT(e.nombre, ' ', e.apellido) AS nombre_completo, e.salario, d.nombre_depto, e.puesto
FROM empleado e
         INNER JOIN departamento d on e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE CONCAT(nombre, ' ', apellido) = 'Mito Barchuk')

-- Consulta 4
SELECT e.* FROM empleado e INNER JOIN departamento d on e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY nombre ASC;

-- Consulta 5
SELECT nombre AS salario 
FROM empleado e INNER JOIN departamento d on e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = 'Ventas' ORDER BY salario ASC LIMIT 1

-- Consulta 6
SELECT nombre AS salario 
FROM empleado e INNER JOIN departamento d on e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = 'Ventas' ORDER BY salario DESC LIMIT 1
