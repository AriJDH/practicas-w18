-- Ejercicio 1
-- 1- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD”
-- y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE IF NOT EXISTS TWD
SELECT epi.* FROM series ser
INNER JOIN seasons sea ON sea.serie_id = ser.id
INNER JOIN episodes epi ON epi.season_id = sea.id
WHERE ser.title = 'The Walking Dead';

-- 2- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT t.*
FROM TWD t
INNER JOIN seasons s on s.id = t.season_id
WHERE s.number = 1;

-- Ejercicio 2
-- 1- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX movies_title_index USING BTREE ON movies_db.movies (title);
SHOW INDEX FROM movies;

-- 2- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- El titulo de las peliculas es una buena opcion debido a que esta no deberia cambiar, o al menos
-- no cambiar frecuentemente, pero si se consultaria de manera frecuente.

