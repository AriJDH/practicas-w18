EXPLAIN SELECT * 
FROM movies
WHERE rating > 8;

/*Agregar una película a la tabla movies.*/
INSERT INTO movies (id, title, rating, awards, release_date, length, genre_id) 
VALUES (22, "Qué pasó ayer", 8.5, 1, "2010-01-01", 120, 1);

/*Agregar un género a la tabla genres*/
INSERT INTO genres (created_at, name, ranking, active) 
VALUES ("2014-07-03 22:00:00", "prueba", 13, 1);

/*Asociar a la película del punto 1. con el género creado en el punto 2*/
UPDATE movies
SET genre_id = 13
WHERE id = 22;

/*Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.*/
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 7;

/*Crear una tabla temporal copia de la tabla movies*/
CREATE TEMPORARY TABLE copia_movies
SELECT * FROM movies;

/*Verificando tabla*/
SELECT *
FROM copia_movies;

/*Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.*/
DELETE FROM copia_movies WHERE awards < 5;

/*Obtener la lista de todos los géneros que tengan al menos una película*/
SELECT g.name, count(*) AS movies
FROM movies m JOIN genres g
ON m.genre_id = g.id
GROUP BY g.name
HAVING movies > 0;

/*Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.*/
SELECT *
FROM actors a JOIN movies m
ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

/*Crear un índice sobre el nombre en la tabla movies.*/
ALTER TABLE movies
ADD INDEX `movie_title` (`title` ASC) VISIBLE;
;

/*Chequee que el índice fue creado correctamente.*/
EXPLAIN SELECT title 
FROM movies
WHERE title LIKE "l%";


