
## Creacion de tablas temporales e indices
#Tabla temporal TWD con los episodios de The walking dead
CREATE TEMPORARY TABLE TWD SELECT episodes.* FROM seasons INNER JOIN episodes ON seasons.id = episodes.season_id WHERE seasons.serie_id = (SELECT id FROM series WHERE title = "The Walking Dead");
#Consulta episodios primera temporada
SELECT TWD.* FROM TWD INNER JOIN seasons ON TWD.season_id = seasons.id WHERE seasons.number = 1;
#Ejercicio 2
#Creamos un indice sobre la columna number de la tabla seasons
ALTER TABLE `movies_db`.`seasons` 
ADD INDEX `indice_numeroTemporada` (`number` ASC) VISIBLE;
#Este indice se podria crear en esta tabla sobre la columna numero en caso de que se hagan muchas consultar en las que
#necesitemos saber el numero de la temporada y relacionarlo por ejemplo con episodios, series, etc.

## Consultas SQL Avanzadas 2
#1. Agregar una pelicula a la tabla movies
INSERT INTO movies (id,created_at,updated_at, title, rating, awards, release_date, length, genre_id) VALUES(22,null,null,"Titanic",7.9,11,"1997-12-19",194,null);
#2. Agregar un genero a la tabla genres
INSERT INTO genres (id,created_at,updated_at,name,ranking,active) VALUES (13,NOW(),Null,"Romance",13,1);
#3. Asociar la pelicula del punto 1, genre el genero creado en el punto 2.alter
UPDATE movies SET genre_id = 13 WHERE id = 22;
#4. modificar la tabla actors para que al menos un actor tenga como favorita la pelicula agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 5;
#5. Crear una tabla temporal copia de la tabla movies;
CREATE TEMPORARY TABLE movies_copy SELECT * FROM movies;
#6. Eliminar de esa tabla temporal todas las peliculas que hayan ganado menos de 5 awards
DELETE FROM movies_copy WHERE awards < 5;
#7. Obtener la lista de todos los generos que tengan al menos una pelicula.
SELECT movies.genre_id,genres.name, COUNT(movies.genre_id) as numero_peliculas FROM movies INNER JOIN genres ON genres.id = movies.genre_id GROUP BY movies.genre_id;
#8. Obtener la lista de actores cuya pelicula favorita haya ganado mas de 3 awards
SELECT actors.* FROM actors INNER JOIN movies ON actors.favorite_movie_id = movies.id WHERE movies.awards > 3;
#9. Crear un indice sobre el nombre en la tabla movies
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `indice_nombre_movies` (`title` ASC) VISIBLE;
#10. Chequee que el indice fue creado correctamente.
SHOW INDEXES FROM movies;
#11. En la base de datos movies. Existira una mejora notable al crear el indice? Analizar y justificar la respuesta.
## Existiria una mejora en caso de que las busquedas en la tabla movies se hagan frecuentemente por el titulo de la pelicula,
## En otro caso, no hay mejora por crear este indice.
#12. En que otra tabla crearia un indice y porque?, justificar la respuesta
## Crearia un indice en la tabla actors, columna name, ya que puede ser muy comun buscar por nombre los actores y 
##relacionarlos a sus peliculas, por lo que crear este indice ayudaria en la rapidez de las consultas.