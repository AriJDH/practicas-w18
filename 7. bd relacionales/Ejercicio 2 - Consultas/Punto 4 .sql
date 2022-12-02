/* 1. Nombre de clientes que viven en Provincia1*/
select nombre 
from Cliente
where provincia = 'provincia1' 

/* 2. Clientes que nacieron despues de 1990*/
select dni as  DNI , nombre as Nombre 
from Cliente
where fecha_nacimiento > 1990-01-01 
Order by Nombre 

/* 3. Planes de internet donde el descuento está entre 10000 y 15000*/
select *
from PlanInternet 
where descuento between 10000 and 15000

/* 4. Traer cinco planes de los 10 almacenados */
select *
from Plan_cliente 
Limit 5

/* 5.Traer Dni, Nombre y Plan de internet de cada cliente */
select Cliente.dni, Cliente.nombre ,Plan_Cliente.PlanInternet_idPlanInternet
from Cliente , Plan_Cliente
where dni = Cliente_dni 

/* 6.  Cliente con id del plan */
select Cliente.* , PlanInternet_idPlanInternet as PLAN 
from  Cliente , Plan_cliente 
where  Cliente_dni= dni

/* 7.  Presento cliente con su respectivo plan asociado  */
select  Cliente.dni as DNI , Cliente.nombre as NOMBRE , PlanInternet_idPlanInternet as PLAN ,PlanInternet.precio as PRECIO  
from  Cliente , Plan_cliente ,PlanInternet
where  Cliente_dni= dni  and Plan_cliente.PlanInternet_idPlanInternet = idPlanInternet

/* 8.  Presento clientes del plan 3 */
select  Cliente.dni as DNI , Cliente.nombre as NOMBRE , PlanInternet_idPlanInternet as PLAN ,PlanInternet.precio as PRECIO  
from  Cliente , Plan_cliente ,PlanInternet
where  Cliente_dni= dni  and Plan_cliente.PlanInternet_idPlanInternet = idPlanInternet and idPlanInternet = 3  

/* 9.  Presento clientes del precio 150000 */
select  Cliente.dni as DNI , Cliente.nombre as NOMBRE , PlanInternet_idPlanInternet as PLAN ,PlanInternet.precio as PRECIO  
from  Cliente , Plan_cliente ,PlanInternet
where  Cliente_dni= dni  and Plan_cliente.PlanInternet_idPlanInternet = idPlanInternet and precio = 150000 

/* 10.  Presento clientes con el descuento minimo */
select  Cliente.dni as DNI , Cliente.nombre as NOMBRE , PlanInternet_idPlanInternet as PLAN ,PlanInternet.precio as PRECIO , PlanInternet.descuento as DESCUENTO 
from  Cliente , Plan_cliente ,PlanInternet
where  Cliente_dni= dni  and Plan_cliente.PlanInternet_idPlanInternet = idPlanInternet and descuento = 5000  


