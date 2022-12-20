/*Mostrar el título y el nombre del género de todas las series.*/
SELECT s.title, g.name
FROM series s JOIN genres g
ON s.genre_id = g.id;

/*Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
SELECT e.title, a.first_name, a.last_name
FROM episodes e 
JOIN actor_episode ae
ON e.id = ae.episode_id
JOIN actors a
ON ae.actor_id = a.id;

/*Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
SELECT s.title, count(t.serie_id) AS seasons
FROM series s JOIN seasons t
ON s.id = t.serie_id
GROUP BY title;

/*Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.*/
SELECT g.name, count(m.id) AS movies
FROM genres g JOIN movies m
ON g.id = m.genre_id 
GROUP BY g.name;

/*Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.*/
SELECT distinct a.first_name, a.last_name
FROM movies m JOIN actor_movie am
ON m.id = am.movie_id
JOIN actors a
ON a.id = am.actor_id
WHERE m.title LIKE "La Guerra de las galaxias%"
ORDER BY a.first_name ASC






