#1 Mostrar todos los registros de la tabla de movies. 
select * from movies;
#2 Mostrar el nombre, apellido y rating de todos los actores.
select first_name, last_name, rating from actors;
#3 Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
select title as Titulo from series as Series;
#4 Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name from actors where rating >= 7.5;
#5 Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 
# y con más de dos premios.
SELECT m.title, m.rating, m.awards FROM movies m WHERE m.rating > 7.5 AND m.awards > 2;
#Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
select title, rating from movies order by rating;
#Mostrar los títulos de las primeras tres películas en la base de datos.
select title from movies limit 3;
#Mostrar el top 5 de las películas con mayor rating
select * from movies order by rating desc limit 5;
#Listar los primeros 10 actores.
select first_name, last_name from actors limit 10;
#Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT m.title, m.rating FROM movies m WHERE m.title LIKE 'Toy Story%';
#Mostrar a todos los actores cuyos nombres empiezan con Sam.
select first_name, last_name from actors where first_name like 'Sam%';
#Mostrar el título de las películas que salieron entre el 2004 y 2008
select title from movies where release_date between '2004-01-01' and '2008-12-31';
#Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento 
#entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT m.title FROM movies m WHERE m.rating > 3 AND m.awards >=1 AND m.release_date >= '1989-01-01' AND m.release_date < '2009-01-01';
SELECT m.title, m.release_date FROM movies m WHERE m.rating > 3 AND m.awards >=1 AND m.release_date >= '1989-01-01' AND m.release_date < '2009-01-01' ORDER BY m.release_date


