/*Ejercicio 3.B. Incorporar 10 registros en la tabla clientes y 5 en la tabla planes de internet*/

INSERT INTO Cliente VALUES  ('1','Natalia','Restrepo','1998-12-16','Provincia','Ciudad');
INSERT INTO Cliente VALUES  ('23456','Ayde','Vizcaya','1998-12-16','Provincia','Ciudad');
INSERT INTO Cliente VALUES  ('34567','Aurora','Vizcaya','1998-12-8','Provincia1','Ciudad2');
INSERT INTO Cliente VALUES  ('45678','Carlos','Manrique','1998-12-16','Provincia2','Ciudad1');
INSERT INTO Cliente VALUES  ('56789','Nelson','Camacho','1998-12-16','Provincia2','Ciudad2');
INSERT INTO Cliente VALUES  ('67890','Janeth','Martinez','1998-12-16','Provincia1','Ciudad1');
INSERT INTO Cliente VALUES  ('71234','Felipe','Lasso','1998-12-16','Provincia2','Ciudad2');
INSERT INTO Cliente VALUES  ('84321','Nicol','Vizcaya','1998-12-16','Provincia1','Ciudad1');
INSERT INTO Cliente VALUES  ('95678','Estfany','Restrepo','1998-12-16','Provincia2','Ciudad2');
INSERT INTO Cliente VALUES  ('10234','Nicolas','Restrepo','1998-12-16','Provincia1','Ciudad');

INSERT INTO PlanInternet VALUES  ('1','30','50000','5000');
INSERT INTO PlanInternet VALUES  ('2','70','80000','10000');
INSERT INTO PlanInternet VALUES  ('3','100','150000','15000');
INSERT INTO PlanInternet VALUES  ('4','150','170000','15000');
INSERT INTO PlanInternet VALUES  ('5','200','190000','15000');


/*Ejercicio 3.C.Realizar las asociaciones/relaciones correspondientes entre estos registros. */

INSERT INTO Plan_Cliente VALUES ('1','5');
INSERT INTO Plan_Cliente VALUES ('23456','2');
INSERT INTO Plan_Cliente VALUES ('34567','3');
INSERT INTO Plan_Cliente VALUES ('45678','1');
INSERT INTO Plan_Cliente VALUES ('56789','2');
INSERT INTO Plan_Cliente VALUES ('67890','4');
INSERT INTO Plan_Cliente VALUES ('71234','2');
INSERT INTO Plan_Cliente VALUES ('84321','3');
INSERT INTO Plan_Cliente VALUES ('95678','4');
INSERT INTO Plan_Cliente VALUES ('10234','3');






