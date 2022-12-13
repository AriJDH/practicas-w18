-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select concat(nombre,' ', apellido) as "Nombre completo", edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad = 'Francia' or nacionalidad = 'Italia';
select * from autor where nacionalidad = 'Argentina' or nacionalidad = 'Uruguay';

-- ¿Qué libros no son del área de internet?
select * from libro where area != 'Internet';
select * from libro where area != 'Fantasía';

-- Listar los libros de la editorial Salamandra.
select * from libro where editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select * from estudiante where apellido like 'g%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre,l.titulo  
from autor a
inner join libroAutor la on a.idautor = la.autor_idAutor
inner join libro l on l.idlibro = la.libro_idlibro;

select a.nombre,l.titulo  
from autor a
inner join libroAutor la on a.idautor = la.autor_idAutor
inner join libro l on l.idlibro = la.libro_idlibro
where l.titulo = 'El Universo: Guía de viaje';

select a.nombre,l.titulo  
from autor a
inner join libroAutor la on a.idautor = la.autor_idAutor
inner join libro l on l.idlibro = la.libro_idlibro
where l.titulo = 'El Aleph';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select * 
from libro l
inner join prestamo p on l.idlibro = p.libro_idLibro 
inner join estudiante e on e.idestudiante = p.estudiante_idestudiante
where concat(e.nombre, ' ', e.apellido) = 'Filipo Galli';

-- Listar el nombre del estudiante de menor edad.
select nombre from estudiante
where edad = (select min(edad) from estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select nombre from estudiante e
inner join prestamo p on e.idEstudiante = p.estudiante_idestudiante 
inner join libro l on l.idlibro = p.libro_idlibro
where l.area = 'Base de Datos';

select nombre from estudiante e
inner join prestamo p on e.idEstudiante = p.estudiante_idestudiante 
inner join libro l on l.idlibro = p.libro_idlibro
where l.area = 'Novela'
group by e.nombre;

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select * from libro l
inner join libroAutor la on l.idlibro = la.libro_idlibro
inner join autor a on a.idautor = la.autor_idautor
where a.nombre = 'J. K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo from libro l
inner join prestamo p on l.idlibro = p.libro_idLibro 
where p.fechaDevolucion = '2021-07-16';

