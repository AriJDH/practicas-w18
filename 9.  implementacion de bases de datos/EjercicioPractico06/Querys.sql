/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE empresa_seguros_db;

/*
	Query para llenar la tabla de vehiculos
*/

INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('1', '2022', '4', 'Honda', 'Civic', '239-HFS');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('2', '2008', '4', 'Chevrolet', 'Corsa', '112-REA');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('3', '2022', '4', 'Renault', 'Kangoo', '876-YTR');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('4', '2006', '4', 'Peugeot', '206', '337-ACN');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('5', '2022', '4', 'Fiat', 'Sienna', '443-POI');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('6', '2019', '8', 'Scania', 'L111', '713-QWE');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('7', '2022', '8', 'Mercedes Benz', '1114', '833-BVC');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('8', '2022', '8', 'Volvo', 'FH16', '209-ELY');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('9', '2018', '8', 'Iveco', 'Tector', '953-IXZ');
INSERT INTO `empresa_seguros_db`.`vehiculos` (`id`, `anio_de_fabricacion`, `cant_ruedas`, `marca`, `modelo`, `patente`) VALUES ('10', '2015', '8', 'Volkswagen', 'Delivery', '652-FUT');

/*
	Query para llenar la tabla de siniestros
*/

INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('1', '2010-11-10', '3000', '1');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('2', '2000-01-10', '9000', '1');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('3', '2001-11-30', '5000', '1');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('4', '2019-05-06', '15000', '2');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('5', '2022-02-12', '15000', '2');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('6', '2019-08-07', '7000', '2');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('7', '2005-12-06', '13000', '3');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('8', '2005-05-07', '6000', '3');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('9', '2022-07-26', '11000', '3');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('10', '2004-10-22', '8000', '4');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('11', '2018-01-06', '2000', '4');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('12', '2008-05-03', '2000', '4');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('13', '2012-12-09', '20000', '5');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('14', '2001-08-21', '20000', '5');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('15', '2004-05-04', '8000', '5');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('16', '2016-02-23', '12000', '6');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('17', '2010-04-13', '5000', '6');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('18', '2011-09-26', '12000', '6');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('19', '2004-11-03', '1000', '7');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('20', '2011-10-09', '3000', '7');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('21', '2014-05-21', '9000', '7');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('22', '2017-05-29', '5000', '8');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('23', '2012-09-25', '30000', '8');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('24', '2021-08-18', '12000', '8');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('25', '2001-06-20', '22000', '9');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('26', '2007-12-26', '11000', '9');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('27', '2004-09-01', '8000', '9');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('28', '2014-02-21', '1000', '10');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('29', '2008-01-15', '4000', '10');
INSERT INTO `empresa_seguros_db`.`siniestros` (`id`, `fecha_siniestro`, `perdida_economica`, `vehiculo_id`) VALUES ('30', '2009-08-24', '4000', '10');