use db;
/* Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. */
select em.nombre, em.puesto, de.localidad 
from empleado em inner join departamento de
on em.depto_nro = de.depto_nro
where em.puesto ="Vendedor";
 /* Visualizar los departamentos con más de cinco empleados. */
select count(*) as total_empleados, de.depto_nro from departamento de inner join empleado em 
on  de.depto_nro=em.depto_nro group by de.depto_nro  having total_empleados >5;
/* Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. */
select em.nombre, em.salario  from empleado em where em.depto_nro in(select de.depto_nro from departamento de ) and em.puesto in(select puesto from empleado where nombre like 'Mito Barchuk');
/* Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. */
select * from empleado where depto_nro in(select depto_nro from departamento where nombre_depto="Contabilidad"  )order by nombre desc;
/*Mostrar el nombre del empleado que tiene el salario más bajo. */
select min(salario)  from empleado;
/* Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. */
select * from empleado where depto_nro in(select depto_nro from departamento where nombre_depto="Ventas") order by salario desc limit 1;
