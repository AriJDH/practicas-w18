-- PARTE INDIVIDUAL PG --
-- Mostrar el título y el nombre del género de todas las series.
select s.title, g.name 
from series s, genres g
where s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name
from episodes e, actors a, actor_episode ae
where e.id = ae.episode_id and a.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, count(*) as 'Total of Seasons'
from series s, seasons t
where s.id = t.serie_id
group by s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(*) as 'Total of Movies'
from genres g, movies m
where g.id = m.genre_id
group by g.name
having count(*)>=3;


-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct a.first_name, a.last_name
from actors a, movies m, actor_movie am
where a.id = am.actor_id and m.id = am.movie_id and m.title like '%guerra de las galaxias%';


-- PARTE GRUPAL VIVO --

-- Agregar una película a la tabla movies.
INSERT INTO movies (id, created_at, updated_at,title,rating,awards,release_date,length,genre_id) 
VALUES (22,now(),null,'Eterno Resplandor',9.9,9,'2004-07-04 00:00:00',90,5);

-- Agregar un género a la tabla genres.
INSERT INTO genres(id,created_at,updated_at,name,ranking,active) 
VALUES(13,now(),null,'Romance',13,1);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id=22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita 
-- la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id=22
WHERE id = 5;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE COPIA(SELECT * FROM movies);
SELECT * FROM COPIA;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from COPIA
where awards<5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
select g.name, count(*) from genres g, movies m
where g.id = m.genre_id
group by g.name;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select concat(a.first_name, ' ', a.last_name) as 'Full Name', m.title, m.awards
from actors a, movies m
where m.id = a.favorite_movie_id and m.awards >3;

-- Crear un índice sobre el nombre en la tabla movies.


-- Chequee que el índice fue creado correctamente.


-- En la base de datos movies ¿Existiría una mejora notable al crear índices? 
-- Analizar y justificar la respuesta.


-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
