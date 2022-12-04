create table if not exists autor
(
    id_autor     int         not null
        primary key,
    nombre       varchar(45) null,
    nacionalidad varchar(45) null
);

create table if not exists estudiante
(
    id_lector int         not null
        primary key,
    nombre    varchar(45) null,
    apellido  varchar(45) null,
    direccion varchar(45) null,
    carrera   varchar(45) null,
    edad      int         null
);

create table if not exists libro
(
    id_libro  int         not null
        primary key,
    titulo    varchar(45) null,
    editorial varchar(45) null,
    area      varchar(45) null
);

create table if not exists libro_autor
(
    id_libro int not null,
    id_autor int not null,
    constraint fk_libro_autor_autor1
        foreign key (id_autor) references autor (id_autor),
    constraint fk_libro_autor_libro
        foreign key (id_libro) references libro (id_libro)
);

create index fk_libro_autor_autor1_idx
    on libro_autor (id_autor);

create index fk_libro_autor_libro_idx
    on libro_autor (id_libro);

create table if not exists prestamo
(
    fecha_prestamo   datetime null,
    fecha_devolucion datetime null,
    devuelto         tinyint  null,
    libro_id_libro   int      not null,
    id_lector        int      not null,
    constraint fk_prestamo_estudiante1
        foreign key (id_lector) references estudiante (id_lector),
    constraint fk_prestamo_libro1
        foreign key (libro_id_libro) references libro (id_libro)
);

create index fk_prestamo_estudiante1_idx
    on prestamo (id_lector);

create index fk_prestamo_libro1_idx
    on prestamo (libro_id_libro);

