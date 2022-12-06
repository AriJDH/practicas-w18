USE empresa; 


# Se requiere obtener las siguientes consultas:
# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT empleado.puesto, departamento.nombre_depto, departamento.localidad
FROM empleado
JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE puesto = 'Vendedor';

# Visualizar los departamentos con más de cinco empleados.
SELECT count(*) as cantEmpleados, departamento.nombre_depto
FROM empleado
INNER JOIN departamento
ON departamento.depto_nro = empleado.depto_nro
GROUP BY departamento.nombre_depto
HAVING cantEmpleados > 2;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.puesto FROM empleado WHERE empleado.nombre = 'Mito' && empleado.apellido = 'Barchuk';
SELECT empleado.puesto FROM emmpleado WHERE concat(nombre, ' ', apellido) = 'Mito Barchuk';

SELECT empleado.puesto, empleado.salario, departamento.nombre_depto
FROM empleado
JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto IN 
    (SELECT empleado.puesto 
    FROM empleado 
    WHERE concat(nombre, ' ', apellido) = 'Mito Barchuk');




# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT nombre_depto FROM departamento WHERE nombre_depto = 'Contabilidad';

SELECT empleado.*
FROM empleado
JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto IN (SELECT nombre_depto FROM departamento WHERE nombre_depto = 'Contabilidad')
ORDER BY empleado.nombre;



# Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario
FROM empleado
WHERE salario = (SELECT min(salario) FROM empleado); 

select * from empleado order by salario desc;


# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre, salario
FROM empleado
WHERE 
    salario = (SELECT max(salario)
                FROM empleado
                INNER JOIN departamento
                ON empleado.depto_nro = departamento.depto_nro
                WHERE departamento.nombre_depto = 'Ventas'); 

SELECT *
FROM empleado
INNER JOIN departamento
ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = 'Ventas'
ORDER BY empleado.salario desc
LIMIT 1;