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

        insert into libro_autor (id_libro, id_autor)
values  (1, 1),
        (2, 2),
        (3, 3),
        (4, 3),
        (5, 5),
        (6, 6),
        (7, 2),
        (8, 2),
        (9, 9),
        (10, 10);

        insert into prestamo (fecha_prestamo, fecha_devolucion, devuelto, libro_id_libro, id_lector)
values  ('2021-07-02 13:31:40', '2021-07-16 13:31:40', null, 1, 1),
        ('2021-07-02 13:31:40', '2021-07-20 13:31:40', null, 2, 2),
        ('2021-07-02 13:31:40', '2021-11-16 13:31:40', null, 3, 3),
        ('2021-07-02 13:31:40', '2021-12-16 13:31:40', null, 4, 4),
        ('2021-07-02 13:31:40', '2021-07-16 13:31:40', null, 5, 5),
        ('2021-07-02 13:31:40', '2021-10-16 13:31:40', null, 6, 6),
        ('2021-07-02 13:31:40', '2021-07-16 13:31:40', null, 7, 7),
        ('2021-07-02 13:31:40', '2021-11-16 13:31:40', null, 8, 8),
        ('2021-07-02 13:31:40', '2021-10-31 13:31:40', null, 9, 9),
        ('2021-07-02 13:31:40', '2021-07-20 13:31:40', null, 10, 10);