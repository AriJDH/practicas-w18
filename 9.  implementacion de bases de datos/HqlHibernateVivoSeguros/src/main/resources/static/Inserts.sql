INSERT INTO VEHICULOS
(ANIO_FABRICACION,CANTIDAD_RUEDAS,MARCA,MODELO,PATENTE,MATRICULA)
VALUES
(2021,4,'Ford','sedan','pat-ford-01','ff01'),
(2021,2,'Tvs','sedan','pat-tvs-01','ff02'),
(2020,4,'Chevrolet','sedan','pat-che-01','ff03'),
(2022,4,'Mazda','sedan','pat-maz-01','ff04'),
(2022,4,'Toyota','sedan','pat-toy-01','ff05');

INSERT INTO SINIESTRO (FECHA_SINIESTRO,PERDIDA_ECONOMICA,ID_VEHICULO_DENUNCIADO)
VALUES
    ('2022-08-04',50000,1),
    ('2022-09-05',50000,2)