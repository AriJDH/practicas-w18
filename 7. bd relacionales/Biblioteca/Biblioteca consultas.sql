USE biblioteca_db;

#Consulta 1
SELECT * FROM autor;
#Consulta 2
SELECT nombre, edad FROM estudiante;
#Consulta 3
SELECT * from estudiante
WHERE carrera="Informática";
#Consulta 4
SELECT * FROM autor
WHERE nacionalidad="francesa" OR nacionalidad="italiana";
#Consulta 5
SELECT * FROM libro
WHERE area="internet";
#Consulta 6
SELECT * FROM libro
WHERE editorial="Salamandra";
#Consulta 7
SELECT * FROM estudiante
WHERE edad > (SELECT avg(edad) FROM estudiante);
#Consulta 8
SELECT nombre FROM estudiante
WHERE apellido LIKE "G%";
#Consulta 9
SELECT a.nombre FROM autor a INNER JOIN libro_autor la INNER JOIN libro l
WHERE a.id_autor=la.id_autor 
	AND la.id_libro=l.id_libro 
	AND l.titulo="El Universo: Guía de viaje";
#Consulta 10
SELECT l.titulo FROM libro l INNER JOIN prestamo p INNER JOIN estudiante e
WHERE l.id_libro=p.id_libro
	AND p.id_lector=e.id_lector
    AND CONCAT(e.nombre, " ",e.apellido)="Filippo Galli";
#Consulta 11
SELECT nombre FROM estudiante
ORDER BY edad
LIMIT 1;
#Consulta 12
SELECT DISTINCT e.nombre FROM libro l INNER JOIN prestamo p INNER JOIN estudiante e
WHERE l.id_libro=p.id_libro
	AND p.id_lector=e.id_lector
    AND l.area="Base de Datos";
#Consulta 13
SELECT l.titulo FROM autor a INNER JOIN libro_autor la INNER JOIN libro l
WHERE a.id_autor=la.id_autor 
	AND la.id_libro=l.id_libro 
	AND a.nombre="J.K. Rowling";
#Consulta 14
SELECT l.titulo FROM libro l INNER JOIN prestamo p
WHERE l.id_libro=p.id_libro
	AND fecha_devolucion="2021-07-16" AND !devuelto;