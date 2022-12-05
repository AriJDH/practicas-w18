-- Mostrar el título y el nombre del género de todas las series.
select s.title, ge.name from series s inner join genres ge on ge.id = s.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select ep.title, ac.first_name, ac.last_name 
from actor_episode ae 
inner join actors ac on ac.id = ae.actor_id
inner join episodes ep on ep.id = ae.episode_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select se.title, count(*) as cantidad_temporadas from seasons ss inner join series se on se.id = ss.serie_id group by se.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select gen.name, count(*) as cantidad_peliculas from movies m inner join genres gen on gen.id = m.genre_id group by gen.name having cantidad_peliculas > 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct act.first_name, act.last_name from actor_movie am 
inner join actors act on act.id = am.actor_id
inner join movies m on m.id = am.movie_id
where m.title like "%La Guerra de las galaxias%"