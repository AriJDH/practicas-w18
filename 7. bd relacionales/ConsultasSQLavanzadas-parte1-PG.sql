# 1. Mostrar el titulo y el nombre del genero de todas las series
SELECT title, name FROM series INNER JOIN genres ON genre_id = genres.id;
# 2. Mostrar el titulo de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.\
SELECT ep.title, act.first_name, act.last_name FROM actor_episode as ae INNER JOIN actors as act ON ae.actor_id = act.id INNER JOIN episodes as ep ON ae.episode_id = ep.id;
# 3. Mostrar el titulo de todas las series y el total de temporadas que tiene cada una de ellas
SELECT series.title, COUNT(ss.serie_id) as num_seasons FROM series INNER JOIN seasons as ss ON series.id = ss.serie_id GROUP BY ss.serie_id;
# 4. Mostrar el nombre de todos los generos y la cantdad total de peliculas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(movies.genre_id) as numero_peliculas FROM genres INNER JOIN movies on genres.id = movies.genre_id GROUP BY genre_id having numero_peliculas > 3;
# 5. Mostrar solo el nombre y apellido de los actores que trabajan en todas las peliculas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT actors.first_name, actors.last_name FROM actors INNER JOIN actor_movie ON actors.id = actor_movie.actor_id WHERE actor_movie.movie_id IN (SELECT id FROM movies WHERE title LIKE "La Guerra de las galaxias%")