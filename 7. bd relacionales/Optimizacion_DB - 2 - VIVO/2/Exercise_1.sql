-- Agregar una película a la tabla movies.
INSERT INTO movies_db.movies 
(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id) 
VALUES (null, null, null, 'Transformers 2', 0.9, 1, '2005-07-04 00:00:00', null, 5)


-- Agregar un género a la tabla genres.
INSERT INTO movies_db.genres (id, created_at, updated_at, name, ranking, active)
 VALUES (null, '2013-07-04 03:00:00', null, 'Estudio', 13, 1)


-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies_db.movies t SET t.genre_id = 22 WHERE t.id = 22


-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE movies_db.actors t SET t.favorite_movie_id = 22 WHERE t.id = 47


-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp (select * from movies);


-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE awards < 5;


-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id,g.name FROM genres g
INNER JOIN movies m on g.id = m.genre_id
GROUP BY 1,2;


-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT c.* FROM actors c
INNER JOIN movies m on c.favorite_movie_id = m.id
WHERE m.awards > 3;



-- Crear un índice sobre el nombre en la tabla movies.
create index movies_title_index
    on movies (title);


-- Chequee que el índice fue creado correctamente.
ERROR // 23000][1062] Duplicate entry 'Big' for key 'movies.movies_title_uindex'



-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
> movies -> name // No deberian haber peliculas con el mismo nombre 



-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
> USERS -> remember_token // Agregaria un indice para que sea unico, ya que no deberian existir tokens iguales.
> SERIES -> title // No deberian haber series con titulos exactamente iguales
> GENRES -> name // No deberian haber generos con el mismo nombre 

