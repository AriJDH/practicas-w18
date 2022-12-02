
#1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
SELECT  DISTINCT dpt.nombre_depto, dpt.localidad, emp.puesto FROM empleado as emp INNER JOIN departamento as dpt ON emp.depto_nro = dpt.depto_nro where emp.puesto = "Vendedor";
#2. Visualizar los departamentos con mas de cinco empleados
SELECT dpt.depto_nro FROM empleado as emp INNER JOIN departamento as dpt ON emp.depto_nro = dpt.depto_nro GROUP BY emp.depto_nro HAVING COUNT(emp.cod_emp) > 2;
#3. Mostrar el nombre, slario y nombre del departamento de los empleados que tengan el mismo puesto que 'Mito Barchuk'
SELECT emp.nombre, emp.salario, dpt.nombre_depto FROM empleado as emp INNER JOIN Departamento as dpt On emp.depto_nro = dpt.depto_nro WHERE puesto = (SELECT puesto FROM empleado WHERE nombre = "Mito" AND apellido = "Barchuk");
#4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT emp.* FROM empleado as emp WHERE emp.depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto = "Contabilidad") ORDER BY emp.nombre;
#5. Mostrar el nombre del empleado que tiene el salario mas bajo
SELECT nombre FROM empleado ORDER BY salario LIMIT 1;
#6. Mostrar los datos del empleado que tiene el salario mas alto en el departamento de 'ventas'
SELECT emp.* FROM empleado as emp WHERE emp.depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto = "Ventas") ORDER BY emp.salario DESC LIMIT 1;