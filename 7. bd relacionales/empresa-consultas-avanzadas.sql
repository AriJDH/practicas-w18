create database libros;
use empresa;

-- 1
select e.nombre, e.puesto, d.localidad from empleado e
inner join departamento d
on e.depto_nro = d.depto_nro;

-- 2
select d.depto_nro, count(*) as empleados from departamento d
left join empleado e
on e.depto_nro = d.depto_nro
group by d.depto_nro
having empleados > 1;

-- 3
select e.nombre, e.salario, d.nombre_depto from empleado e
left join departamento d
on e.depto_nro = d.depto_nro
where e.puesto = (select puesto from empleado where nombre = 'Daniel' and apellido = 'Brezezicki');

-- 4
select e.* from empleado e
inner join departamento d
on e.depto_nro = d.depto_nro
where d.nombre_depto = 'contabilidad'
order by e.nombre;

-- 5
explain select nombre, salario from empleado
order by cast(salario as unsigned) desc
limit 1;

explain select e.nombre, e.salario
from empleado e
where e.salario = (select min(salario) from empleado);

-- 6
select e.nombre, e.salario, d.nombre_depto from empleado e
join departamento d 
on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Ventas'
order by cast(salario as unsigned) desc
limit 1;

--
select * from empleado;