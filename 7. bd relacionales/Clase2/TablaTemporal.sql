/*Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.*/
CREATE TEMPORARY TABLE TWD 
SELECT e.id AS id_episodio, e.title AS episodio, t.id AS id_temporada, t.title AS temporada, s.id AS id_serie, s.title AS serie
FROM episodes e JOIN seasons t
ON e.season_id = t.id
JOIN series s
ON t.serie_id = s.id
WHERE s.title = "The Walking Dead"
;

SELECT * 
FROM TWD
WHERE temporada = "Primer Temporada";

INSERT INTO TWD
VALUES(50, "prueba", 50, "Primer Temporada", 3, "The Walking Dead")
