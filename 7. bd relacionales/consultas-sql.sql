show databases;
show tables;
use movies_db;

select * from movies;
select first_name, last_name, rating from actors;
select title as titulo from series;
select first_name, last_name, rating from actors where rating > 7.5;
select title, rating, awards from movies where rating > 7.5 and awards > 2;
select title, rating from movies order by rating;
select title from movies limit 3;
select * from movies order by rating desc limit 5;
select * from actors limit 10;
select title, rating from movies where title like "%Toy Story%";
select * from actors where first_name like "Sam%";
/* Mostrar el título de las películas que salieron entre el 2004 y 2008. */
select * from movies where release_date between'2004-01-01'  and '2008-12-31';
select * from movies where year(release_date) between 2004 and 2008;
/* Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating. */
select title from movies where rating>3 and awards>1 and release_date between '1988-01-01' and '2009-12-31' order by rating;
select title from movies where rating > 3 and awards > 1 and year(release_date) between 1988 and 2009 order by rating;