INSERT INTO `empresa_internet`.`clientes`
(`dni`,
`nombre`,
`apellido`,
`fecha_nacimiento`,
`provincia`,
`ciudad`)
VALUES
('1020','Cristian','Ronaldo','2020-04-04','Antioquia','Medellín'),
('1021','Lionel','Messi','2001-06-12','Atlantico','Santa Marta'),
('1022','Andres','Iniesta','2000-06-07','Atlantico','Cartagena'),
('1023','Sergio','Ramos','1999-06-19','Antioquia','Itagui'),
('1024','Segio','Aguero','2003-08-16','Antioquia','Barbosa'),
('1025','James','Rodriguez','2000-06-12','Cundinamarca','Bogotá'),
('1026','Andres','Ricaute','2000-01-19','Antioquia','La estrella'),
('1027','Estella','Rojas','2001-02-18','Cundinamarca','Bayacá'),
('1028','Angela','Gritona','2002-06-21','Cundinamarca','Bayacá'),
('1029','Ruth','Giraldo','2001-06-15','Cundinamarca','Bayacá');

INSERT INTO `empresa_internet`.`planes`
(`megas`,`precio`,`descuento`) VALUES
(50,150000,0),
(100,300000,0),
(150,350000,0),
(200,400000,0),
(300,470000,0.7);

/*truncate table `empresa_internet`.`clientes_planes`;*/

INSERT INTO `empresa_internet`.`clientes_planes`
(`cliente_id`,`plan_id`)
VALUES
(1,5),
(2,5),
(3,1),
(4,3),
(10,5),
(6,1),
(10,1),
(5,1),
(5,5),
(5,4);
