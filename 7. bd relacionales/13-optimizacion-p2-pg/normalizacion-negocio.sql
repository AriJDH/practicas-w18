-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE `factura` (
    `id` int(11)  NOT NULL ,
    `fecha` date  NOT NULL ,
    `forma_pago` decimal(10,0)  NOT NULL ,
    `iva` decimal(10,0)  NOT NULL ,
    `importe` decimal(10,0)  NOT NULL ,
    `id_cliente` int  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `cliente` (
    `id` int(11)  NOT NULL ,
    `nombre` varchar(40)  NOT NULL ,
    `apellido` varchar(40)  NOT NULL ,
    `direccion` varchar(40)  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `factura_articulo` (
    `id` int(11)  NOT NULL ,
    `id_factura` int(11)  NOT NULL ,
    `id_articulo` int(11)  NOT NULL ,
    `cantidad` int(11)  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

CREATE TABLE `articulo` (
    `id` int(11)  NOT NULL ,
    `descripcion` varchar(40)  NOT NULL ,
    PRIMARY KEY (
        `id`
    )
);

ALTER TABLE `factura` ADD CONSTRAINT `fk_factura_id_cliente` FOREIGN KEY(`id_cliente`)
REFERENCES `cliente` (`id`);

ALTER TABLE `factura_articulo` ADD CONSTRAINT `fk_factura_articulo_id_factura` FOREIGN KEY(`id_factura`)
REFERENCES `factura` (`id`);

ALTER TABLE `factura_articulo` ADD CONSTRAINT `fk_factura_articulo_id_articulo` FOREIGN KEY(`id_articulo`)
REFERENCES `articulo` (`id`);

