# Ejercicio 1
#############
# 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada 
# “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
DROP TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE IF NOT EXISTS TWD
SELECT epi.* FROM series ser
inner join seasons sea on sea.serie_id = ser.id
inner join episodes epi on epi.season_id = sea.id
where ser.title = "The Walking Dead";
SELECT *
FROM TWD twd;
# 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT t.*
FROM TWD t
inner join seasons s on s.id=t.season_id
where s.number = 1;
#
# Ejercicio 2
#############
# 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y 
# luego chequear la creación del mismo. 
CREATE INDEX movies_title_IDX USING BTREE ON movies_db.movies (title);
SHOW INDEX FROM movies;
# 2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio
# se elige/n el/los campos.
# Porque el titulo no cambiaria demasiado frecuente y es algo que se podria consultar frecuentemente.
