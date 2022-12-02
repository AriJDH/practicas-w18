#Mostrar todos los registros de la tabla movies
SELECT * FROM movies;
#Mostrar el nombre, apellido y rating de todos los actores
SELECT first_name,last_name,rating FROM actors;
#Mostrar el titulo de todas las series y usar alias para que tanto el nombre de la tabla como el campo esten en español
SELECT title as titulo FROM series;
# Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5
SELECT first_name, last_name FROM actors WHERE rating > 7.5;
#Mostrar el titulo de las peliculas, el rating y los premios de las peliculas con un rating mayor a 7.5 y con mas de dos premios
SELECT title, rating,awards FROM movies WHERE rating > 7.5 AND awards > 2;
#Mostrar el titulo de las peliculas y el rating ordenadas por rating en forma ascendente
SELECT title, rating FROM movies ORDER BY rating ASC;
# Mostrar los titulos de las primeras tres peliculas en la base de datos
SELECT title FROM movies LIMIT 3;
# Mostrar el top 5 de las peliculas con mayor rating
SELECT * FROM movies ORDER BY rating DESC LIMIT 5;
#Listar los 10 primeros actores
SELECT * FROM actors LIMIT 10;
#Mostrar el titulo y rating de todas las peliculas cuyo titulo sea toy story
SELECT * FROM movies WHERE title LIKE "Toy Story%";
# Mostrar a todos los actores cuyos nombres empiezan con Sam
SELECT * FROM actors WHERE first_name LIKE "Sam%";
#Mostrar el titulo de las peliculas que salieron entre 2004 y 2008
SELECT title FROM movies WHERE release_date BETWEEN "2004-01-01" AND "2008-12-31";
#Traer el titulo de las peliculas con el rating mayor a 3, con mas de 1 premio con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT * FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN "1988-01-01" AND "2009-12-31" ORDER BY rating;


