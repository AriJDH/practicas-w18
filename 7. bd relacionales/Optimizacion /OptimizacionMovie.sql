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
DELETE  FROM  COPIA 
WHERE awards <=5;


-- Obtener la lista de todos los géneros que tengan al menos una película.
select distinct genres.name
from genres,movies m 
where m.genre_id > 1;



-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select actors.first_name 
from actors,movies
where favorite_movie_id = movies.id and movies.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.

CREATE UNIQUE INDEX titleInd on movies (title)


-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies; 

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? 
/* La diferencia no es muy notoria ya que el tamaño de la misma y las consultas que se realizan no requieren de multiples tablas o tablas con mucha información.
Los índices serán notoríos en bases de datos de gran tamañano donde las consultas resulten más complejas.
 */


-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

