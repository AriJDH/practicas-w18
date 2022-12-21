/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE movies_db;

/*
	1. Agregar una película a la tabla movies.
*/
INSERT INTO movies (id, title, rating, awards, release_date, length) VALUES (22, "Rapido y Furioso I", 7.5, 1, "2001-5-12", 106);

/*
	2. Agregar un género a la tabla genres.
*/
INSERT INTO genres (id, created_at, name, ranking, active) VALUES (13, "2022-12-20", "Crimen", 13, 1);

/*
	3. Asociar a la película del punto 1. genre el género creado en el punto 2
*/
UPDATE `movies_db`.`movies` SET `genre_id` = '13' WHERE (`id` = '22');

/*
	4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
*/
UPDATE `movies_db`.`actors` SET `favorite_movie_id` = '22' WHERE (`id` = '47');

/*
	5. Crear una tabla temporal copia de la tabla movies.
*/
CREATE TEMPORARY TABLE moviesCopia
SELECT *
FROM movies;

/*
	6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
*/
DELETE 
FROM moviesCopia
WHERE awards < 5;

/*
	7. Obtener la lista de todos los géneros que tengan al menos una película.
*/
SELECT DISTINCT genres.*
FROM genres
JOIN movies ON movies.genre_id = genres.id;

/*
	8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
*/
SELECT actors.*, movies.title, movies.awards
FROM actors
JOIN actor_movie ON actors.id = actor_movie.actor_id
JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.awards > 3;

/*
	9. Crear un índice sobre el nombre en la tabla movies.
*/
CREATE INDEX title_idx ON movies (title);

/*
	10. Chequee que el índice fue creado correctamente.
    
    R: Se verificó correctamente en el panel lateral izquierdo
*/

/*
	11. En la base de datos movies ¿Existiría una mejora notable al crear índices?
    Analizar y justificar la respuesta.
    
    R: Si, al momento de hacer busquedas baja considerablemente la cantidad de registros que se deben checkear
*/

/*
	12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
    
    R: En la tabla de actores. Porque como en peliculas, al crecer en cantidad al momento de buscar un actor
    por nombre me puede ser mas performatico que tengo un segundo indice, en este caso "apellido"
*/