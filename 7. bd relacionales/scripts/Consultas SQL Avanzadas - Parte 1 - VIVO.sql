-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT em.nombre, em.puesto, dep.localidad FROM empleado em INNER JOIN departamento dep ON em.depto_nro = dep.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
select dep.nombre_depto, count(*) as cantidad_empleados from departamento dep INNER JOIN empleado em ON em.depto_nro = dep.depto_nro group by dep.nombre_depto having cantidad_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select em.nombre, em.salario, dep.nombre_depto from empleado em INNER JOIN departamento dep ON em.depto_nro = dep.depto_nro WHERE em.puesto = (SELECT puesto from empleado where nombre = "Mito" and apellido = "Barchuk")

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM empleado em INNER JOIN departamento dep ON em.depto_nro = dep.depto_nro WHERE dep.nombre_depto = "contabilidad" order by em.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select * from empleado em where em.salario = (select min(salario) from empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select * from empleado where salario = (select max(em.salario) from empleado em inner join departamento dep ON em.depto_nro = dep.depto_nro where dep.nombre_depto = "ventas")