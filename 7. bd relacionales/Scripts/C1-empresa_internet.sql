USE empresa_internet; 
SELECT * FROM empresa_internet.Cliente;
SELECT * FROM Plan;
SELECT * FROM Plan_has_Cliente;



INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('2', '11123123', 'Juan', 'Sosa', '1980-12-01', 'Mendoza', 'Capital');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('3', '12300123', 'Sofia', 'Monasterio', '1970-12-01', 'Santa Fe', 'Rosario');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('4', '11230123', 'Leonor', 'Germano', '1960-12-01', 'San Luis', 'Villa Mercedes');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('5', '11001233', 'Mariana', 'Ingrassia', '2000-12-01', 'La Pampa', 'Santa Rosa');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('6', '11000123', 'Marco', 'Davila', '1995-12-01', 'Rio Negro', 'Cipolletti');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('7', '00100123', 'Martin', 'Rocamora', '1988-12-01', 'San Juan', 'San Juan');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('8', '10100123', 'Carlos', 'Romualdo', '1976-12-01', 'Neuquen', 'Catriel');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('9', '10010123', 'Santiago', 'Miranda', '1975-12-01', 'Catamarca', 'Fiambalá');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('10', '11000133', 'Mariela', 'Alfonso', '1990-12-01', 'Salta', 'Salta');



INSERT INTO `empresa_internet`.`Plan` (`idPlan`, `velocity_mb`, `price`, `discount`) VALUES ('3', '20', '2000', '10');
INSERT INTO `empresa_internet`.`Plan` (`velocity_mb`, `price`, `discount`) VALUES ('20', '2000', '10');
INSERT INTO `empresa_internet`.`Plan` (`velocity_mb`, `price`, `discount`) VALUES ('20', '2000', '10');


INSERT INTO `empresa_internet`.`Plan_has_Cliente` (`Plan_idPlan`, `Cliente_idClient`) VALUES ('1', '2');
INSERT INTO `empresa_internet`.`Plan_has_Cliente` (`Plan_idPlan`, `Cliente_idClient`) VALUES ('1', '3');
INSERT INTO `empresa_internet`.`Plan_has_Cliente` (`Plan_idPlan`, `Cliente_idClient`) VALUES ('1', '4');
INSERT INTO `empresa_internet`.`Plan_has_Cliente` (`Plan_idPlan`, `Cliente_idClient`) VALUES ('1', '5');
INSERT INTO `empresa_internet`.`Plan_has_Cliente` (`Plan_idPlan`, `Cliente_idClient`) VALUES ('1', '6');
INSERT INTO `empresa_internet`.`Plan_has_Cliente` (`Plan_idPlan`, `Cliente_idClient`) VALUES ('2', '7');
INSERT INTO `empresa_internet`.`Plan_has_Cliente` (`Plan_idPlan`, `Cliente_idClient`) VALUES ('4', '8');
INSERT INTO `empresa_internet`.`Plan_has_Cliente` (`Plan_idPlan`, `Cliente_idClient`) VALUES ('3', '9');



# Plantear 10 consultas SQL
SELECT * FROM Plan_has_Cliente;

# 1 Cuántos clientes tienen el plan 1
SELECT count(Plan_idPlan)
FROM Plan_has_Cliente
WHERE Plan_idPlan = 1;

# 2 Clientes que tengan el plan 1
SELECT Cliente.name, Plan_has_Cliente.Plan_idPlan
FROM Cliente 
JOIN Plan_has_Cliente
ON Cliente.idClient = Plan_has_Cliente.Cliente_idClient
WHERE Plan_has_Cliente.Plan_idPlan = 1;


# 3 De qué provincia son los clientes con plan 1
SELECT Cliente.name, Cliente.province, Plan_has_Cliente.Plan_idPlan
FROM Cliente 
JOIN Plan_has_Cliente
ON Cliente.idClient = Plan_has_Cliente.Cliente_idClient
WHERE Plan_has_Cliente.Plan_idPlan = 1;

# 4 Mostrar el descuento que tiene cada cliente con Plan 1
SELECT Cliente.name, Plan_has_Cliente.Plan_idPlan, Plan.discount
FROM Cliente 
JOIN Plan_has_Cliente
ON Cliente.idClient = Plan_has_Cliente.Cliente_idClient
JOIN Plan
ON Plan.idPlan = Plan_has_Cliente.Plan_idPlan
WHERE Plan_has_Cliente.Plan_idPlan = 1;

# 5 Mostrar el precio y número de plan con velocidad mayor a 20Mb
SELECT price, idPlan FROM Plan
WHERE velocity_mb > 20;

# 6 Mostrar clientes y plan de la ciudad de Catriel
SELECT Cliente.name, Cliente.city, Plan_has_Cliente.Plan_idPlan as Plan
FROM Cliente
JOIN Plan_has_Cliente
ON Cliente.idClient = Plan_has_Cliente.Cliente_idClient
WHERE city = 'Catriel';

# 7 Mostrar clientes cuyo año de nacimiento sea entre 1975 y 1980
SELECT Cliente.name, Cliente.birthdate
FROM Cliente
WHERE YEAR(birthdate) BETWEEN 1975 AND 1980;

# 8 Mostrar clientes cuyo año de nacimiento sea entre 1975 y 1980 y su Plan
SELECT Cliente.name, Cliente.birthdate, Plan_has_Cliente.Plan_idPlan
FROM Cliente
JOIN Plan_has_Cliente
ON Cliente.idClient = Plan_has_Cliente.Cliente_idClient
WHERE YEAR(birthdate) BETWEEN 1975 AND 1980;

# 9 Mostrar ingreso total mensual para el plan 1
SELECT SUM(Plan.price), Plan.idPlan
FROM Plan
JOIN Plan_has_Cliente
ON Plan.idPlan = Plan_has_Cliente.Plan_idPlan
GROUP BY Plan.idPlan
HAVING Plan.idPlan = 1;

# 10 Mostrar el plan que actualmente genera más ingresos a la empresa







