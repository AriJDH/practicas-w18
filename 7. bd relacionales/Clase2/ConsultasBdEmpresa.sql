SELECT e.nombre, e.puesto, d.localidad
FROM departamento d JOIN empleado e
ON e.depto_nro = d.depto_nro;

SELECT depto_nro, count(*) AS empleados
FROM empleado
GROUP BY depto_nro
HAVING empleados > 5;

SELECT e.nombre, e.salario, d.nombre_depto
FROM departamento d JOIN empleado e
ON e.depto_nro = d.depto_nro
WHERE e.puesto = "Presidente";

SELECT *
FROM empleado e LEFT JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre ASC;

SELECT nombre
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

SELECT *
FROM empleado e LEFT JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Ventas" AND salario = (SELECT MAX(salario) FROM empleado WHERE depto_nro = "D-000-4")
ORDER BY e.nombre ASC;




