# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT 
    e.nombre, e.puesto, d.localidad
FROM
    empleado e
        INNER JOIN
    departamento d ON e.depto_nro = d.depto_nro;

# Visualizar los departamentos con más de cinco empleados.
SELECT 
    d.*
FROM
    departamento d
        JOIN
    empleado e ON d.depto_nro = e.depto_nro
GROUP BY d.iddepartamento
HAVING COUNT(*) > 5;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’

SELECT 
    e.nombre, e.salario, d.nombre_depto, e.puesto
FROM
    departamento d
        JOIN
    empleado e ON d.depto_nro = e.depto_nro
WHERE
    e.puesto = (SELECT 
            e1.puesto
        FROM
            empleado e1
        WHERE
            e1.nombre = 'Mito'
                AND e1.apellido = 'Barchuk');

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT 
    e.nombre, e.salario, d.nombre_depto, e.puesto
FROM
    departamento d
        JOIN
    empleado e ON d.depto_nro = e.depto_nro
WHERE
    d.nombre_depto = 'contabilidad'
ORDER BY d.nombre_depto;

# Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT 
    e.nombre, e.salario
FROM
    empleado e
ORDER BY e.salario
LIMIT 1;

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT 
    e.nombre, e.salario
FROM
    departamento d
        JOIN
    empleado e ON d.depto_nro = e.depto_nro
WHERE
    d.nombre_depto = 'ventas'
ORDER BY e.salario DESC
LIMIT 1;