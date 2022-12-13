USE movies_db;

-- Listar todos los actores que tengan declarada una película favorita.

SELECT 
    *
FROM
    actors
WHERE
    favorite_movie_id IS NOT NULL;

-- Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
SELECT 
    *
FROM
    actors
WHERE
    rating > 9;

-- Listar todos los actores que trabajan en la <película recibida por parámetro>
SELECT 
    a.first_name, a.last_name, GROUP_CONCAT(m.title)
FROM
    actors a
        LEFT JOIN
    actor_movie am ON a.id = am.actor_id
        LEFT JOIN
    movies m ON am.movie_id = m.id
WHERE
    m.title LIKE 'Titanic'
GROUP BY a.id;
  
-- Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
SELECT 
    m.title, COUNT(a.id) AS actors
FROM
    actors a
        INNER JOIN
    actor_movie am ON a.id = am.actor_id
        INNER JOIN
    movies m ON am.movie_id = m.id
WHERE
    a.rating > 5
GROUP BY m.title
HAVING COUNT(a.id);

-- Listar todas las películas que pertenezcan al <género recibido por parámetro>
SELECT 
    m.title
FROM
    movies m
        INNER JOIN
    genres g ON m.genre_id = g.id
WHERE
    g.name LIKE 'Drama';
    
-- Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
SELECT 
    s.*, COUNT(ss.id)
FROM
    series s
        INNER JOIN
    seasons ss ON s.id = ss.serie_id
GROUP BY s.id
HAVING COUNT(ss.id) > 5;

-- Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
SELECT e.*
FROM episodes e
INNER JOIN actor_episode ae
ON e.id = ae.episode_id
INNER JOIN actors a
ON ae.actor_id = a.id
WHERE a.id = 32;

