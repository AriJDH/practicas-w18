SELECT * FROM biblioteca.autor;

INSERT INTO `biblioteca`.`autor` (`nombre`) VALUES ('J. K. Rowling');
UPDATE `biblioteca`.`autor` SET `nacionalidad` = 'Argentina' WHERE (`id_autor` = '1');
INSERT INTO `biblioteca`.`autor` (`nombre`, `nacionalidad`) VALUES ('Jorge Luis Borges', 'Argentina');
INSERT INTO `biblioteca`.`autor` (`nombre`, `nacionalidad`) VALUES ('Roberto Arlt', 'Argentina');

SELECT * FROM biblioteca.estudiante;
