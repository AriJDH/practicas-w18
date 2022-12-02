-- EJERCICIO 1
-- 1
CREATE TEMPORARY TABLE IF NOT EXISTS TWD_episodes
SELECT EP.id as id, EP.created_at as created_at ,EP.updated_at as update_at,
Ep.title as Eposodios, Ep.number as number, Ep.rating as rating, SEA.title as temporada, SER.title as Serie
FROM movies_db.series SER
INNER JOIN movies_db.seasons SEA ON SER.id = SEA.serie_id
INNER JOIN movies_db.episodes EP ON SEA.id = EP.season_id
WHERE SER.title = "The Walking Dead";
-- 2
SELECT * FROM TWD_episodes where temporada = "Primer Temporada";

-- EJERCICIO 2
-- 1
CREATE UNIQUE INDEX title_season_episodes_idx
ON episodes (title,season_id);

show index from episodes;