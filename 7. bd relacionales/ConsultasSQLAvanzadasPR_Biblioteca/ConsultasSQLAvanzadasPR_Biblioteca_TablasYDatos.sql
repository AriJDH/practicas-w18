DROP DATABASE IF EXISTS biblioteca_pr_sql_ns;
CREATE DATABASE biblioteca_pr_sql_ns;
USE biblioteca_pr_sql_ns;

CREATE TABLE libro (
  idLibro INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(128) NOT NULL,
  editorial VARCHAR(64) NOT NULL DEFAULT 'Desconocida',
  area VARCHAR(64),
  PRIMARY KEY(idLibro)
);

CREATE TABLE autor (
  idAutor INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(64) NOT NULL,
  nacionalidad VARCHAR(32) NOT NULL,
  PRIMARY KEY(idAutor)
);

CREATE TABLE estudiante (
  idLector INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(64) NOT NULL,
  apellido VARCHAR(64) NOT NULL,
  direccion VARCHAR(128) NOT NULL,
  carrera VARCHAR(64) NOT NULL,
  edad INT NOT NULL CHECK (edad >0),
  PRIMARY KEY(idLector)
);

CREATE TABLE libroautor(
    idAutor INT NOT NULL,
    idLibro INT NOT NULL,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES autor (idAutor) on delete cascade,
    FOREIGN KEY (idLibro) references libro (idLibro) on delete cascade
);

CREATE TABLE prestamo(
    idLector INT NOT NULL,
    idLibro INT NOT NULL,
    fechaPrestamo DATETIME NOT NULL DEFAULT(curdate()),
    fechaDevolucion DATETIME NOT NULL DEFAULT(date_add(curdate(), INTERVAL 1 DAY)),
    fechaDevuelto DATETIME,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES estudiante (idLector) on delete cascade,
    FOREIGN KEY (idLibro) references libro (idLibro) on delete cascade
);

INSERT INTO libro (titulo, editorial, area) VALUES 
('Harry Potter I', 'EditorialInglesa', 'Fantasía'),
('Harry Potter II', 'EditorialInglesa', 'Fantasía'),
('Harry Potter III', 'EditorialInglesa', 'Fantasía'),
('El Señor de los Anillos I', 'EditorialX', 'Fantasía'),
('El Señor de los Anillos II', 'EditorialX', 'Fantasía'),
('El Señor de los Anillos III', 'EditorialX', 'Fantasía'),
('Vigilar y Castigar', 'Salamandra', 'Filosofía');

INSERT INTO autor (nombre, nacionalidad) VALUES 
('Michel Foucault', 'Francesa'),
('JRR Tolkien', 'Inglesa'),
('JK Rowling', 'Inglesa');

INSERT INTO libroautor VALUES (3,1),(3,2),(3,3),(2,4),(2,5),(2,6),(1,7);

INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES 
('Nicolás', 'Sánchez','DirecciónX','Informática',30),
('Maria', 'Perez','DirecciónY','Arquitectura',20);

INSERT INTO prestamo (idLector, idLibro) VALUES (1,4),(1,5),(1,6);