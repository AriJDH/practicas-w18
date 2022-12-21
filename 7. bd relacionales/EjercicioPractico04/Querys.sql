/*
	La Seteamos en default para que le resto de las instrucciones se ejecuten sin problema
*/
USE movies_db;

/*
1. Mosrtar el titulo y el nombre del genero de todas las series
*/
SELECT series.title, genres.name
FROM series 
JOIN genres 
ON series.genre_id = genres.id;

/*
2. Mostrar el título de los episodios, el nombre y apellido 
   de los actores que trabajan en cada uno de ellos
*/ 
SELECT episodes.title, actors.first_name, actors.last_name
FROM episodes
JOIN actor_episode
ON episodes.id = actor_episode.episode_id
JOIN actors 
ON actor_episode.actor_id = actors.id;
   
/*
3. Mostrar el titulo de todas las series y el total de 
   temporadas que tiene cada una de ellas
*/
SELECT series.title, COUNT(seasons.number)
FROM series JOIN seasons
ON seasons.serie_id = series.id
GROUP BY series.title;

/* 
4. Mostrar el nombre de todos los géneros y la cantidad 
   total de películas por cada uno, siempre que sea mayor o igual a 3 
*/
SELECT genres.name, COUNT(movies.title) AS total_movies
FROM genres JOIN movies
ON movies.genre_id = genres.id
GROUP BY genres.name HAVING total_movies >= 3;

/*
5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas 
las películas de la guerra de las galaxias y que estos no se repitan
*/
SELECT DISTINCT actors.first_name, actors.last_name
FROM actors
JOIN actor_movie
ON actors.id = actor_movie.actor_id
JOIN movies
ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE '%Guerra de las galaxias%';
