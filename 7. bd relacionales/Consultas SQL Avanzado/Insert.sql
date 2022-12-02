INSERT INTO `departamento_empleado`.`departamento`
(`depto_nro`,
`nombre_depto`,
`localidad`)
VALUES
('D-000-1','Software','Los Tigres'),
('D-000-2','Sistemas','Guadalupe'),
('D-000-3','Contabilidad','La Roca'),
('D-000-4','Ventas','Plata');


INSERT INTO `departamento_empleado`.`empleado`
(`cod_emp`,
`nombre`,
`apellido`,
`puesto`,
`fecha_alta`,
`salario`,
`comision`,
`depto_nro`)
VALUES
('E-0001','César','Piñero','Vendedor','2018-05-12',80000,15000,'D-000-4'),
('E-0002','Yosep','Kowaleski','Analista','2015-07-17',140000,0,'D-000-2'),
('E-0003','Mariela','Barrios','Directo','2014-06-05',185000,0,'D-000-3'),
('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03',85000,10000,'D-000-4'),
('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03',83000,10000,'D-000-4'),
('E-0006','Mito','Barchuk','Presidente','2014-06-05',80000,0,'D-000-3'),
('E-0007','Emilio','Galarza','Desarrollador','2014-08-02',60000,0,'D-000-1');
