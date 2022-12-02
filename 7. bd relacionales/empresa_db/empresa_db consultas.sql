USE empresa_db;

#Consulta 1
SELECT e.nombre, e.puesto, d.localidad FROM empleado e INNER JOIN departamento d
WHERE e.depto_nro=d.depto_nro;

#Consulta 2
SELECT depto_nro, nombre_depto, localidad FROM departamento d
WHERE (SELECT COUNT(e.cod_emp) FROM empleado e WHERE e.depto_nro=d.depto_nro)>5;

#Consulta 3
SELECT e.nombre, e.salario, d.nombre_depto FROM empleado e INNER JOIN departamento d
WHERE e.puesto = (SELECT puesto FROM empleado WHERE CONCAT(nombre, " ", apellido)="Mito Barchuk");

#Consulta 4
SELECT e.nombre, e.apellido, e.puesto FROM empleado e INNER JOIN departamento d
WHERE d.nombre_depto="Contabilidad"
ORDER BY 1;

#Consulta 5
SELECT nombre FROM empleado
ORDER BY salario
LIMIT 1;

#Consulta 6
SELECT e.nombre FROM empleado e INNER JOIN departamento d
WHERE d.nombre_depto="Contabilidad"
ORDER BY e.salario DESC
LIMIT 1;