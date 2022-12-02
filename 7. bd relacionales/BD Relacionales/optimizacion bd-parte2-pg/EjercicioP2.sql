use movies_db;
# Agregar una película a la tabla movies.
insert into movies values
( 22, null, null, "Pepito", 15, 11, '2022-12-01', null, null);
# Agregar un género a la tabla genres.
insert into genres values
(13,'2010-07-04 03:00:00',NULL,'Comedia','22','1');
# Asociar a la película del punto 1. con el género creado en el punto 2.
update movies set genre_id = 13 where id=22;
# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id= 22 where id = 49;
# Crear una tabla temporal copia de la tabla movies.
create temporary table moviestemp select * from movies;
# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from moviestemp where awards <=5;
# Obtener la lista de todos los géneros que tengan al menos una película.
select distinct gen.* from genres gen inner join movies mo
on gen.id=mo.genre_id;
