INSERT INTO `Biblioteca`.`autor`
(`nombre`,
`nacionalidad`)
VALUES
('Gabriel Garcia Marquez','Colombiano'),
('William Shakespeare','Ingles'),
('Jorge Luis Borges','Argentino'),
('Miguel de Cervantes','Español'),
('Homero','Griego');

INSERT INTO `Biblioteca`.`estudiante`
(`nombre`,
`apellido`,
`direccion`,
`carrera`,
`edad`)
VALUES
('Andres','Iniesta','Calle luna calle sol','Derecho',27),
('Valentina','Torres','Avenida siempre viva','Psicologia',20),
('Estefany','Cabrera','Los laureles','Ingenieria de sistemas',17),
('Felipe','Builes','Cerca al sol','Mecatrónica',18),
('Jorge','Agudelo','Calle luna calle sol','Ingenieria de sistemas',35);

INSERT INTO `Biblioteca`.`libro`
(`titulo`,
`editorial`,
`area`)
VALUES
('Cien años de soledad','Santillana','Novela'),
('El amor en los tiempos del cólera','Babel','Novela'),
('Hamlet','Babel','Tragedia'),
('Don Quijote de la Mancha','Santillana','Novela'),
('Odisea','Babel','Poema épico');

INSERT INTO `Biblioteca`.`libroautor`
(`idlibro`,
`idautor`)
VALUES
((SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'Cien años de soledad'),(SELECT idautor FROM Biblioteca.autor WHERE nombre = 'Gabriel Garcia Marquez')),
((SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'El amor en los tiempos del cólera'),(SELECT idautor FROM Biblioteca.autor WHERE nombre = 'Gabriel Garcia Marquez')),
((SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'Hamlet'),(SELECT idautor FROM Biblioteca.autor WHERE nombre = 'William Shakespeare')),
((SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'Don Quijote de la Mancha'),(SELECT idautor FROM Biblioteca.autor WHERE nombre = 'Miguel de Cervantes')),
((SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'Odisea'),(SELECT idautor FROM Biblioteca.autor WHERE nombre = 'Homero'));

INSERT INTO `Biblioteca`.`prestamo`
(`idlector`,
`idlibro`,
`fechaprestamo`,
`fechadevolucion`,
`devuelto`)
VALUES
((SELECT idlector FROM Biblioteca.estudiante WHERE nombre = 'Andres'),(SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'Cien años de soledad'),CURDATE(),NULL,0),
((SELECT idlector FROM Biblioteca.estudiante WHERE nombre = 'Valentina'),(SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'Hamlet'),CURDATE(),NULL,0),
((SELECT idlector FROM Biblioteca.estudiante WHERE nombre = 'Valentina'),(SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'Odisea'),CURDATE(),NULL,0),
((SELECT idlector FROM Biblioteca.estudiante WHERE nombre = 'Felipe'),(SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'El amor en los tiempos del cólera'),CURDATE(),NULL,0),
((SELECT idlector FROM Biblioteca.estudiante WHERE nombre = 'Andres'),(SELECT idlibro FROM Biblioteca.libro WHERE titulo = 'Don Quijote de la Mancha'),CURDATE(),NULL,0);





