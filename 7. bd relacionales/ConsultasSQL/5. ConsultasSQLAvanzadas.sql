-- Se propone realizar las siguientes consultas a la base de datos movies_db.sql trabajada en la primera clase.
-- Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:

USE movies_db;

-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name 
FROM series s
INNER JOIN genres g
ON s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title,  a.first_name as nombre, a.last_name as apellido
FROM actors a
INNER JOIN actor_episode ae
ON a.id = ae.actor_id
INNER JOIN episodes e
ON ae.episode_id = e.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(sea.id) as seasons
FROM series s
INNER JOIN seasons sea
ON s.id = sea.serie_id
GROUP BY s.id;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(g.id) movies
FROM genres g
INNER JOIN movies m
ON g.id = m.genre_id
GROUP BY g.id
HAVING COUNT(g.id) >= 3;


-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name, a.last_name, GROUP_CONCAT(m.title)
FROM actors a
LEFT JOIN actor_movie am
ON a.id = am.actor_id
LEFT JOIN movies m
ON am.movie_id = m.id
WHERE m.title LIKE "La Guerra de las Galaxias%"
GROUP BY a.id;

