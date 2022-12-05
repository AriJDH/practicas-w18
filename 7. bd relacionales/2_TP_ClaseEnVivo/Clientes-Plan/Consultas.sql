-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.
-- 1) Nombre y Apellido de los clientes de la provincia Mendoza
select c.nombre, c.apellido from clientes c
where c.provincia = 'Mendoza';

-- 2) Nombre y Apellido de los clientes de la ciudad Maipu
select c.nombre, c.apellido from clientes c
where c.ciudad = 'Maipu';

-- 3) Nombre y Cantidad de clientes por provincia
select c.provincia, count(*) as 'Cantidad de clientes' from clientes c
group by c.provincia;

-- 4) Nombre y Cantidad de clientes por ciudades de aquellas que tengan más de 5 clientes
select c.ciudad, count(*) as 'Cantidad de clientes' from clientes c
group by c.ciudad
having count(*) > 5;

-- 5) Velocidad del plan y cantidad de clientes que lo contrataron
select p.velocidad_plan, count(*) 'Cantidad de clientes' from planes p
inner join clientes_planes cxp on cxp.idPlan
group by p.velocidad_plan;

-- 6) Velocidad del plan que más haya sido contratada por los clientes
select p.velocidad_plan, count(*) 'Cantidad de clientes'  from planes p
inner join clientes_planes cxp on cxp.idPlan
group by p.velocidad_plan
order by count(*) desc
limit 1;

-- 7) Nombre y Apellido de los clientes y precio con los planes con el precio más alto
select c.nombre, c.apellido, p.precio from clientes c
inner join clientes_planes cxp on cxp.idCliente = c.id
inner join planes p on p.id = cxp.idPlan
where p.precio in (select max(precio) from planes);

-- 8) Nombre y Apellido de los clientes y precio con los planes con el precio más bajo
select c.nombre, c.apellido, p.precio from clientes c
inner join clientes_planes cxp on cxp.idCliente = c.id
inner join planes p on p.id = cxp.idPlan
where p.precio in (select min(precio) from planes);

-- 9) Nombre y Apellido de los clientes y precio con los planes con el precio arriba del promedio
select c.nombre, c.apellido, p.precio from clientes c
inner join clientes_planes cxp on cxp.idCliente = c.id
inner join planes p on p.id = cxp.idPlan
where p.precio > (select avg(precio) from planes);

-- 10) Nombre y Apellido de los clientes y precio con los planes con el precio menor o igual del promedio
select c.nombre, c.apellido, p.precio from clientes c
inner join clientes_planes cxp on cxp.idCliente = c.id
inner join planes p on p.id = cxp.idPlan
where p.precio <= (select avg(precio) from planes);




