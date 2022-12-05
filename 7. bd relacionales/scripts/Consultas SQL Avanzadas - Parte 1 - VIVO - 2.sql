insert into autor (id_autor, nombre, nacionalidad)
values  (1, 'Sumner Pennicard', 'Italiano'),
        (2, 'J.K. Rowling', 'Frances'),
        (3, 'Filippo Galli', 'Vyshneve'),
        (4, 'Olivette Withringten', 'Tampa'),
        (5, 'Dewey Bugg', 'Nouakchott'),
        (6, 'Tedi Caygill', 'Agdangan'),
        (7, 'Berti Tatlock', 'Frances'),
        (8, 'Mikey Elves', 'Rio das Ostras'),
        (9, 'Josselyn Koles', 'Carmelo'),
        (10, 'Isabelita Betho', 'Italiano');


        insert into estudiante (id_lector, nombre, apellido, direccion, carrera, edad)
values  (1, 'Merle', 'Beininck', '0891 Warrior Avenue', 'Informatica', 28),
        (2, 'Feliza', 'Euplate', '76 Shasta Terrace', 'Engineer I', 46),
        (3, 'Talbot', 'Tomanek', '45171 Kedzie Hill', 'Informatica', 33),
        (4, 'Faith', 'Noke', '374 Northwestern Way', 'Quality Control Specialist', 26),
        (5, 'Konrad', 'Boecke', '29066 Dunning Road', 'Software Consultant', 49),
        (6, 'Jamil', 'Bloodworth', '9 Drewry Trail', 'Dental Hygienist', 42),
        (7, 'Lawry', 'Carrell', '7 Fordem Parkway', 'Sales Associate', 32),
        (8, 'Krishna', 'McCarry', '4 Corscot Park', 'Help Desk Technician', 39),
        (9, 'Andros', 'Greenig', '6752 Melrose Drive', 'Office Assistant IV', 43),
        (10, 'Verine', 'Cornbell', '8 Morning Pass', 'Cost Accountant', 29);

        insert into libro (id_libro, titulo, editorial, area)
values  (1, 'El Universo: Guía de viaje', 'Oligonucleotides', 'Internet'),
        (2, 'The Four Feathers', 'Salamandra', 'Web Developer I'),
        (3, 'Lilya 4-Ever (Lilja 4-ever)', 'Agile Testing', 'Administrative Assistant II'),
        (4, 'Field in England, A', 'MM modules', 'Quality Engineer'),
        (5, 'Musketeers of Pig Alley, The', 'Salamandra', 'Environmental Tech'),
        (6, 'Pickpocket', 'PDF Creator', 'Internet'),
        (7, 'Ran', 'Salamandra', 'Base de Datos'),
        (8, 'The Frame', 'IBS', 'Base de Datos'),
        (9, 'Storyville', 'Salamandra', 'General Manager'),
        (10, 'American History X', 'Lyrical', 'Internet');

        insert into libro_autor (id_libro_autor, id_libro, id_autor)
values  (1, 1, 1),
        (2, 2, 2),
        (3, 3, 3),
        (4, 4, 3),
        (5, 5, 5),
        (6, 6, 6),
        (7, 7, 2),
        (8, 8, 2),
        (9, 9, 9),
        (10, 10, 10);

        insert into prestamo (id_prestamo, fecha_prestamo, fecha_devolucion, devuelto, id_libro, id_lector)
values  (1, '2021-07-02 13:31:40', '2021-07-16 13:31:40', null, 1, 1),
        (2, '2021-07-02 13:31:40', '2021-07-20 13:31:40', null, 2, 2),
        (3, '2021-07-02 13:31:40', '2021-11-16 13:31:40', null, 3, 3),
        (4, '2021-07-02 13:31:40', '2021-12-16 13:31:40', null, 4, 4),
        (5, '2021-07-02 13:31:40', '2021-07-16 13:31:40', null, 5, 5),
        (6, '2021-07-02 13:31:40', '2021-10-16 13:31:40', null, 6, 6),
        (7, '2021-07-02 13:31:40', '2021-07-16 13:31:40', null, 7, 7),
        (8, '2021-07-02 13:31:40', '2021-11-16 13:31:40', null, 8, 8),
        (9, '2021-07-02 13:31:40', '2021-10-31 13:31:40', null, 9, 9),
        (10, '2021-07-02 13:31:40', '2021-07-20 13:31:40', null, 10, 10);
        
# Listar los datos de los autores.
SELECT * FROM autor;

# Listar nombre y edad de los estudiantes
SELECT nombre,edad FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre,e.edad FROM estudiante e WHERE e.carrera = 'informatica';

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.nombre,a.nacionalidad FROM autor a WHERE a.nacionalidad IN ('italiano', 'frances');

# ¿Qué libros no son del área de internet?
SELECT titulo, area FROM libro WHERE area <> 'internet';

# Listar los libros de la editorial Salamandra.
SELECT titulo, area FROM libro WHERE editorial = 'Salamandra';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, edad FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido like "g%";

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
INNER JOIN libro_autor la on a.id_autor = la.id_autor
INNER JOIN libro l on la.id_libro = l.id_libro
WHERE l.titulo = 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo FROM prestamo p
INNER JOIN libro l on l.id_libro = p.id_libro
inner join estudiante es on es.id_lector = p.id_lector
WHERE es.nombre = 'Filippo' and es.apellido = "Galli";


# Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiante
WHERE edad = (SELECT MIN(edad) FROM estudiante);

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT e.nombre FROM estudiante e
INNER JOIN prestamo p on e.id_lector = p.id_lector
INNER JOIN libro l on p.id_libro = l.id_libro
WHERE l.area = 'Base de Datos';

# diferencias??
SELECT DISTINCT e.nombre FROM prestamo p
INNER JOIN estudiante e on e.id_lector = p.id_lector
INNER JOIN libro l on p.id_libro = l.id_libro
WHERE l.area = 'Base de Datos';

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo FROM libro l
INNER JOIN libro_autor la on l.id_libro = la.id_libro
INNER JOIN autor a on la.id_autor = a.id_autor
WHERE a.nombre = 'J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT distinct l.titulo, p.fecha_devolucion FROM prestamo p
LEFT JOIN libro l ON p.id_libro AND l.id_libro
WHERE p.fecha_devolucion BETWEEN '2021-07-16 00:00:00' AND '2021-07-17 23:59:00';


        