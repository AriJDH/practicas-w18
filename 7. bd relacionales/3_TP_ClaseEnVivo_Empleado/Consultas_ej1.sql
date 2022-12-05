-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad
from empleado e 
inner join departamento d on d.depto_nro = e.depto_nro
where e.depto_nro = "D-000-4";

-- Visualizar los departamentos con más de cinco empleados.
select d.nombre_depto
from empleado e 
inner join departamento d on d.depto_nro = e.depto_nro
group by d.nombre_depto
having count(*) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto
from empleado e 
inner join departamento d on d.depto_nro = e.depto_nro
inner join (select e.puesto from empleado e where e.nombre = "Mito" and e.apellido = "Barchuk" ) e2 on e2.puesto = e.puesto;

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.*
from empleado e 
inner join departamento d on d.depto_nro = e.depto_nro
where d.depto_nro = "D-000-3"
order by e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select e.nombre, e.salario
from empleado e 
order by cast(e.salario as unsigned) 
limit 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*
from empleado e 
inner join departamento d on d.depto_nro = e.depto_nro
where d.depto_nro = "D-000-4"
order by cast(e.salario as unsigned) desc
limit 1;

	
