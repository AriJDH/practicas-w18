USE movies_db;

#Consultas básicas
#Consulta 1
SELECT * FROM movies;
#Consulta 2
SELECT first_name, last_name, rating FROM actors;
#Consulta 3
SELECT title AS titulo FROM movies AS peliculas;
#Consulta 4
SELECT first_name, last_name FROM actors
WHERE rating>7.5;
#Consulta 5
SELECT title, rating, awards FROM movies
WHERE rating>7.5 AND awards>2;
#Consulta 6
SELECT title, rating FROM movies
ORDER BY rating;
#Consulta 7
SELECT title FROM movies LIMIT 3;
#Consulta 8
SELECT title FROM movies 
ORDER BY rating DESC
LIMIT 5;
#Consulta 9
SELECT CONCAT(first_name, " ", last_name) AS nombre_completo 
FROM actors
LIMIT 10; 
#Consulta 10
SELECT title, rating FROM movies
WHERE title = "Toy Story";
#Consulta 11
SELECT * FROM actors
WHERE first_name LIKE "Sam%";
#Consulta 12
SELECT * FROM movies
WHERE YEAR(release_date) BETWEEN 2004 AND 2008;
#Consulta 13
SELECT title FROM movies
WHERE rating>3
AND awards>1
AND YEAR(release_date) BETWEEN 1988 AND 2009;

#Consultas avanzadas
#Consulta 1
SELECT s.title AS titulo_serie, g.name as nombre_genero
FROM series s INNER JOIN genres g
WHERE s.genre_id=g.id;
#Consulta 2
SELECT e.title AS titulo_episodio, CONCAT(a.first_name, " ", a.last_name) AS nombre_actor
FROM episodes e INNER JOIN actor_episode ae INNER JOIN actors a
WHERE e.id=ae.episode_id AND ae.actor_id=a.id ;
#Consulta 3
SELECT serie.id as serie_id,serie.title as serie_titulo, COUNT(season.id) as cantidad_temporadas
FROM series serie INNER JOIN seasons season
WHERE serie.id=season.serie_id
GROUP BY serie_id;
#Consulta 4
SELECT g.id AS genre_id, g.name AS genre_name, COUNT(m.id) AS cantidad_peliculas
FROM genres g INNER JOIN movies m
WHERE g.id=m.genre_id
GROUP BY genre_id
HAVING cantidad_peliculas>=3;
#Consulta 5
SELECT CONCAT(a.first_name, " ", a.last_name) as nombre_completo FROM
actors a INNER JOIN actor_movie am INNER JOIN movies m
WHERE a.id=am.actor_id AND am.movie_id=m.id
	AND m.title like "%Guerra de las galaxias%"
GROUP BY nombre_completo
HAVING COUNT(nombre_completo) = (SELECT COUNT(id) FROM movies WHERE title like "%Guerra de las galaxias%")