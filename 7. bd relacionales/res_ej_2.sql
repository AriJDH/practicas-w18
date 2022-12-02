/* 1 -  Mostrar todos los registros de la tabla de movies.  */
SELECT * FROM movies_db.actor_movie;

/* 2 - Mostrar el nombre, apellido y rating de todos los actores.  */
select first_name as Nombre, last_name as Apellido, rating from movies_db.actors;

/* 3 - Mostrar el título de todas las series y usar 
alias para que tanto el nombre de la tabla como el campo estén en español.
 */ 
select title as Título from movies_db.series Series;

/* 4 - Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
 */
 SELECT 
    first_name AS Nombre, last_name AS Apellido
FROM
    movies_db.actors
WHERE
    rating >= 7.5;
    
/* 5 - Mostrar el título de las películas, el rating y los premios de las 
películas con un rating mayor a 7.5 y con más de dos premios. */
select title, rating, awards
from movies_db.movies
where rating >= 7.5
and awards > 2;

/* 6 - Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.  */ 
select title
from movies_db.movies
order by title asc;

/* 7 - Mostrar los títulos de las primeras tres películas en la base de datos. */
select title
from movies_db.movies
limit 3;

/* 8 - Mostrar el top 5 de las películas con mayor rating. */
select *
from movies_db.movies
order by rating desc
limit 5;

/* 9 - Listar los primeros 10 actores. */
select *
from movies_db.actors
limit 10;

/* 10 - Mostrar el título y rating de todas las películas cuyo título sea de Toy Story. */
select title, rating
from movies_db.movies
where title like "%Toy Story%";

/* 11 - Mostrar a todos los actores cuyos nombres empiezan con Sam. */
select * from movies_db.actors where first_name like 'Sam%';

/* 12 - Mostrar el título de las películas que salieron entre el 2004 y 2008. */
select *
from movies_db.movies
where YEAR(release_date) between 2004 and 2008;

/* 13 - Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de 
lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating. */
Select title
from movies_db.movies 
where rating >= 3 and awards > 1 
and year(release_date) between 1988 and 2009;