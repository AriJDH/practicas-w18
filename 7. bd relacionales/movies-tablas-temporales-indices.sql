USE movies_db

-- CREAR UNA TABLA TEMPORAL LLAMADA "TWD" Y GURADAR EN LA MISMA LOS EPISODIOS DE TODAS 
-- LAS TEMPORADAS DE "The Walking Dead".
CREATE TEMPORARY TABLE TWD
(titulo varchar(40), temporada int(50));

INSERT INTO TWD 
SELECT episodes.title, season_id
FROM episodes
INNER JOIN seasons
ON peisodes.season_id = seasons.id
WHERE seasons.serie_id = 3;

-- SELECCIONAR UNA TABLA DONDE CREAR UN INDICE Y LUEGO CHEQUEAR LA CREACION DEL
-- MISMO
ALTER TABLE movies
ADD INDEX fecha_salida (release_date ASC) VISIBLE;

EXPLAIN
SELECT * 
FROM movies
WHERE release_date = "2010-10-04";
