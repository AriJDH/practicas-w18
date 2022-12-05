/* 1.Mostrar el título y el nombre del género de todas las series.*/
select title as Titulo, genres.name as Genero 
from series,genres
where series.genre_id= genres.id

/* 2.Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.*/
select episodes.title ,  actors.first_name , actors.last_name 
from episodes , actor_episode, actors
where actors.id = actor_episode.id 
order by title ASC



/* 3.Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
select s.title as Titulo_Serie,  t.number as Total_Temporadas 
from series s, seasons t
where s.id = t.id 
group by s.id 


/* 4.Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3  */
select g.name as Genero, COUNT(g.name) as Total_Películas 
from genres g ,movies m
where g.id = m.genre_id 
group by g.name 
having COUNT(g.name) = 3 or COUNT(g.name) > 3 

/* 5.Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.*/
select a.first_name as Nombre, a.last_name as Apellido 
from actors a , actor_movie am 
where am.movie_id= 3 or am.movie_id= 4 and am.id = a.id
group by a.id
order by first_name ASC

