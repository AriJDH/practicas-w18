CREATE TABLE clientes (
	id int unsigned NOT NULL AUTO_INCREMENT,
	nombre varchar(50) NOT NULL,
    apellido varchar(50) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	provincia varchar(50),
	ciudad varchar(50),
	PRIMARY KEY (id)
);

create table planes ( 
	id int unsigned auto_increment NOT NULL,
	velocidad_plan varchar(50) NOT NULL,
	precio decimal(5,2) NOT NULL,
	descuento int unsigned NOT NULL,
    PRIMARY KEY (id)
 );

create table clientes_planes ( 
	id int unsigned auto_increment NOT NULL,
	idCliente int unsigned NOT NULL,
    idPlan int unsigned NOT NULL,
    PRIMARY KEY (id),
	KEY cliente_plan_idCliente (idCliente),
	KEY cliente_plan_idPlan (idPlan),
	CONSTRAINT cliente_plan_idCliente FOREIGN KEY (idCliente) REFERENCES clientes (id),
	CONSTRAINT cliente_plan_idPlan FOREIGN KEY (idPlan) REFERENCES planes (id)
 );

 
insert into clientes values(1,"Jose","Perez","1990-12-12","Mendoza","Maipu");
insert into clientes values(2,"Arturo","Perez","1989-12-12","Mendoza","Maipu");
insert into clientes values(3,"Pepe","Perez","1988-12-12","Mendoza","Maipu");
insert into clientes values(4,"Martin","Perez","1987-12-12","Mendoza","Maipu");
insert into clientes values(5,"Sebastian","Perez","1986-12-12","Mendoza","Maipu");
insert into clientes values(6,"Mailu","Perez","1985-12-12","Mendoza","Maipu");
insert into clientes values(7,"Andres","Perez","1984-12-12","Mendoza","Maipu");
insert into clientes values(8,"MVP","Perez","1983-12-12","Mendoza","Maipu");
insert into clientes values(9,"Maria","Perez","1982-12-12","Mendoza","Maipu");
insert into clientes values(10,"Luis","Perez","1981-12-12","Mendoza","Maipu");

insert into planes values(1,"15mbs",7.2,10);
insert into planes values(2,"20mbs",17.2,20);
insert into planes values(3,"25mbs",27.2,30);
insert into planes values(4,"30mbs",37.2,40);
insert into planes values(5,"35mbs",47.2,50);

insert into clientes_planes values(1,1,1);
insert into clientes_planes values(2,2,2);
insert into clientes_planes values(3,3,3);
insert into clientes_planes values(4,4,4);
insert into clientes_planes values(5,5,5);
insert into clientes_planes values(6,6,1);
insert into clientes_planes values(7,7,2);
insert into clientes_planes values(8,8,3);
insert into clientes_planes values(9,9,4);
insert into clientes_planes values(10,10,5);

 select * from clientes;
 select * from planes;
 select * from clientes_planes;
 