/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE movies_db;

/*
	1.1 Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar 
    en la misma los episodios de todas las temporadas de “The Walking Dead”.
*/
CREATE TEMPORARY TABLE TWD
    SELECT episodes.*, series.title as title_series, seasons.number as seasons_number
    FROM series
    JOIN seasons
    ON  series.id = seasons.serie_id
    JOIN episodes
    ON seasons.id = episodes.season_id
    WHERE series.title like 'The Walking Dead';
    
/*
	1.2 Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/
SELECT * FROM TWD WHERE seasons_number = 2;

/*
	2.1 En la base de datos “movies”, seleccionar una tabla donde crear un índice
    y luego chequear la creación del mismo.
    
    R: El criterio que se eligió fue pensar cual seria un caso comun de filtrado. En este caso, filtrar
    por derterminadas peliculas que tengan una x cantidad de premios. Se puede notar como creando un indice
    en la columna "awards" mejora la performance de la busqueda.
*/
EXPLAIN SELECT *
FROM movies
WHERE movies.awards > 5;

CREATE TEMPORARY TABLE moviesDuplicado
SELECT *
FROM movies;

CREATE INDEX awards_idx ON moviesDuplicado (awards);

EXPLAIN SELECT *
FROM moviesDuplicado
WHERE moviesDuplicado.awards > 5;