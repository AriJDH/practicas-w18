use biblioteca;
/*Listar los datos de los autores.*/
select * from autor;   
/*Listar nombre y edad de los estudiantes*/
select nombre, edad from estudiante;
#¿Qué estudiantes pertenecen a la carrera Informática?
select * from estudiante where carrera like 'Informática';
#¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad in( 'francesa' , 'italiana');
#¿Qué libros no son del área de internet?
select * from libro where area <>'internet';
#Listar los libros de la editorial Salamandra.
select * from libro where editorial in('Salamandra');
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select AVG(edad) from estudiante);
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre from estudiante where nombre like '%G';
#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select nombre from autor where idautor in(select idautor from libroautor where idlibro in(select idlibro from libro where titulo = 'El Universo: Guía de viaje'));
#¿Qué libros se prestaron al lector “Filippo Galli”?
select * from libro where idlibro in(select idlibro from prestamo where idlector in(select idlector from estudiante where nombre = 'Filippo Galli'));
#Listar el nombre del estudiante de menor edad.
select  nombre from estudiante where edad in(select min(edad) from estudiante);
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select nombre from estudiante where idlector in(select idlector from prestamo where idlibro in(select idlibro from libro where area like 'Base de Datos'));
#Listar los libros que pertenecen a la autora J.K. Rowling.
select * from libro where idlibro in(select idlibro from libroautor where idautor in(select idautor from autor where nombre = 'J.k Rowling'));
#Listar títulos de los libros que debían devolverse el 16/07/2021.
select * from libro where idlibro in(select idlibro from prestamo where fecha_devolucion='2022-11-20');
select * from libro where idlibro in(select idlibro from prestamo where fecha_devolucion='2021-07-16');