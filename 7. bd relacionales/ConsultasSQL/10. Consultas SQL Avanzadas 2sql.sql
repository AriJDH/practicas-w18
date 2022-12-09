USE movies_db;

-- 1. Agregar una película a la tabla movies.

INSERT INTO movies
VALUES(
default,
null,
null,
"Titulo X",
9.0,
10,
"1997-09-04 00:00:00",
230,
4);

-- 2. Agregar un género a la tabla genres.

INSERT INTO genres
VALUES(
default,
"2014-07-04 03:00:00",
"2014-07-04 03:00:00",
"Genero Nuevo",
14.0,
1);

-- 3. Asociar a la película del punto 1. con el género creado en el punto 2.

SELECT 
    id
FROM
    movies
WHERE
    title LIKE 'Titulo X';

UPDATE movies 
SET 
    genre_id = 14
WHERE
    id = 23;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE actors
SET
	favorite_movie_id = 14
WHERE
	id = 10;

-- 5. Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE movies_temp
SELECT m.id, m.title, m.rating, m.awards
FROM  movies m;


-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DROP TEMPORARY TABLE IF EXISTS movies_temp;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.

SELECT g.name, COUNT(m.id) AS count
FROM genres g
INNER JOIN movies m
ON g.id = m.genre_id
GROUP BY m.genre_id
HAVING count >= 1;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.first_name, a.last_name, m.title, m.awards
FROM actors a
INNER JOIN movies m
ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.

ALTER TABLE movies
ADD INDEX title_idx
(title);

-- 10. Chequee que el índice fue creado correctamente.

SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? 
-- Analizar y justificar la respuesta.

-- RTA: Sí, por la gran cantidad de datos que hay, los índices permitirían optimizar consultas.

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

-- Crearía otro índice en la tabla Géneros, porque considero que también serían muy consultados buscando por nombres.