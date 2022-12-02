-- 1.
SELECT E.nombre,E.puesto,D.localidad FROM empresa_db.empleado E
INNER JOIN empresa_db.departamento D ON E.depto_nro = D.depto_nro
where puesto = "Vendedor";

-- 2.
SELECT D.depto_nro,D.nombre_depto,Count(*) as cantidad_empleados FROM empresa_db.empleado E
INNER JOIN empresa_db.departamento D ON E.depto_nro = D.depto_nro
GROUP BY E.depto_nro
HAVING cantidad_empleados > 5;

-- 3.
SELECT E.nombre,E.salario,D.nombre_depto FROM empresa_db.empleado E
INNER JOIN empresa_db.departamento D ON E.depto_nro = D.depto_nro
WHERE Puesto = (SELECT puesto FROM empresa_db.empleado WHERE cod_emp = "E-0006" LIMIT 1)
AND cod_emp <> "E-0006";

-- 4.
SELECT * FROM empresa_db.empleado
WHERE depto_nro = "D-000-3"
ORDER BY nombre;

-- 5.
SELECT * FROM empresa_db.empleado
ORDER BY CAST(salario as float) ASC LIMIT 1;

-- 6.
SELECT * FROM empresa_db.empleado E
WHERE depto_nro= "D-000-4"
ORDER BY CAST(salario as float) DESC LIMIT 1;