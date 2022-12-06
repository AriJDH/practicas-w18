/* Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”. */

CREATE TEMPORARY TABLE TWD
SELECT epi.* FROM series ser
inner join seasons sea on sea.serie_id = ser.id
inner join episodes epi on epi.season_id = sea.id
where ser.title = "The Walking Dead";

/* Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada. */


