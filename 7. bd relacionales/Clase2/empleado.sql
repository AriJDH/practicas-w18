#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
select nombre, puesto, localidad
from departamento join empresa_db.empleado
where departamento.depto_nro = empleado.depto_nro;

#Visualizar los departamentos con más de cinco empleados#
select departamento.depto_nro, count(*) as tot_emp
from empleado join departamento on empleado.depto_nro = departamento.depto_nro 
group by departamento.depto_nro
having tot_emp >5;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Daniel Daniel’.
select nombre, salario, nombre_depto 
from empleado join departamento on empleado.depto_nro = departamento.depto_nro
where empleado.puesto = (select puesto from empleado where nombre = 'Daniel' AND apellido = 'Daniel');

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select * from empleado e
inner join departamento d
on e.depto_nro = d.depto_nro
where e.depto_nro = (select depto_nro from departamento where nombre_depto = "Contabilidad")
order by e.nombre;

# Mostrar el nombre del empleado que tiene el salario más bajo.
select e.nombre
from empleado e
order by cast(e.salario as unsigned)
limit 1;

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*
from empleado e
inner join departamento d on e.depto_nro = d.depto_nro  
where d.nombre_depto = 'Ventas'
order by CAST(e.salario as unsigned) desc
limit 1;
