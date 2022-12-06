USE empresa_internet; 
SELECT * FROM empresa_internet.Cliente;


INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('2', '11123123', 'Juan', 'Sosa', '1980-12-01', 'Mendoza', 'Capital');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('3', '12300123', 'Sofia', 'Monasterio', '1970-12-01', 'Santa Fe', 'Rosario');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('4', '11230123', 'Leonor', 'Germano', '1960-12-01', 'San Luis', 'Villa Mercedes');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('5', '11001233', 'Mariana', 'Ingrassia', '2000-12-01', 'La Pampa', 'Santa Rosa');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('6', '11000123', 'Marco', 'Davila', '1995-12-01', 'Rio Negro', 'Cipolletti');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('7', '00100123', 'Martin', 'Rocamora', '1988-12-01', 'San Juan', 'San Juan');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('8', '10100123', 'Carlos', 'Romualdo', '1976-12-01', 'Neuquen', 'Catriel');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('9', '10010123', 'Santiago', 'Miranda', '1975-12-01', 'Catamarca', 'Fiambalá');
INSERT INTO `empresa_internet`.`Cliente` (`idClient`, `dni`, `name`, `lastname`, `birthdate`, `province`, `city`) VALUES ('10', '11000133', 'Mariela', 'Alfonso', '1990-12-01', 'Salta', 'Salta');


SELECT * FROM Plan;
INSERT INTO `empresa_internet`.`Plan` (`idPlan`, `velocity_mb`, `price`, `discount`) VALUES ('3', '20', '2000', '10');
INSERT INTO `empresa_internet`.`Plan` (`velocity_mb`, `price`, `discount`) VALUES ('20', '2000', '10');
INSERT INTO `empresa_internet`.`Plan` (`velocity_mb`, `price`, `discount`) VALUES ('20', '2000', '10');


