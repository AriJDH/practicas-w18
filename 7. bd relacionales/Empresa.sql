-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad
from empleado e inner join departamento d on e.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
select count(*) as total, d.nombre_depto from departamento d 
inner join empleado e on e.depto_nro = d.depto_nro
group by d.nombre_depto having total >5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto
from empleado e 
inner join departamento d on e.depto_nro = d.depto_nro
where e.puesto = (select puesto from empleado where concat(nombre,' ', apellido) = 'Mito Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select * from empleado e 
inner join departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = 'Contabilidad'
order by e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select e.nombre
from empleado e
where e.salario = (select min(salario) from empleado);

select * from empleado order by salario asc;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.nombre
from empleado e
where e.salario = (select max(salario) from empleado e
				inner join departamento d on e.depto_nro = d.depto_nro
				where d.nombre_depto = 'Ventas');
                
SELECT *
FROM empleado em
INNER JOIN departamento de
ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = 'Ventas'
ORDER BY em.salario desc
LIMIT 1;
