/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
select nombre,puesto,localidad
from empresa.empleado
join empresa.departamento
on departamento.depto_nro = empleado.depto_nro;

/*Visualizar los departamentos con más de cinco empleados.*/


/*Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/
select empleado.nombre,empleado.salario,departamento.nombre_depto 
from empresa.empleado
inner join empresa.departamento
on empleado.depto_nro = departamento.depto_nro
where empleado.puesto = (select puesto from empleado where concat(nombre, ' ', apellido) = 'Mito Barchuk');

/*Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/
select *
from empresa.empleado
inner join empresa.departamento
on empleado.depto_nro = departamento.depto_nro
where departamento.nombre_depto = 'Contabilidad'
order by empleado.nombre ASC;

/*Mostrar el nombre del empleado que tiene el salario más bajo.*/
select nombre
from empresa.empleado
where salario = (select min(salario) from empresa.empleado);

/*Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
select *
from empresa.empleado
inner join empresa.departamento
where salario = (select max(salario) from empresa.empleado where departamento.nombre_depto = 'Ventas');