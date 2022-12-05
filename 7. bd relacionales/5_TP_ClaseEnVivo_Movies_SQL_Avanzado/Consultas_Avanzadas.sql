/*
CREATE TEMPORARY TABLE TWD
SELECT epi.*, sea.number as season_number FROM series ser
inner join seasons sea on sea.serie_id = ser.id
inner join episodes epi on epi.season_id = sea.id
where ser.title = "The Walking Dead";
*/

-- Mostrar el título y el nombre del género de todas las series.
select s.title, g.name from series s
inner join genres g on g.id = s.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name from episodes e
inner join actor_episode axe on axe.episode_id = e.id
inner join actors a on a.id = axe.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select ser.title, count(*) as 'Total temporadas' from series ser
inner join seasons sea on sea.serie_id = ser.id
group by ser.id, ser.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select gen.name, count(*) as 'Cantidad de películas' from genres gen
inner join movies mov on mov.genre_id = gen.id
group by gen.id, gen.name
having count(*) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct act.first_name, act.last_name from actors act
inner join actor_movie axm on axm.actor_id = act.id
inner join movies mov on mov.id = axm.movie_id
where mov.title like 'La Guerra de las galaxias%';



