USE movies_db;

#Consulta 1
SELECT * FROM movies;
#Consulta 2
SELECT first_name, last_name, rating FROM actors;
#Consulta 3
SELECT title AS titulo FROM movies AS peliculas;
#Consulta 4
SELECT first_name, last_name FROM actors
WHERE rating>7.5;
#Consulta 5
SELECT title, rating, awards FROM movies
WHERE rating>7.5 AND awards>2;
#Consulta 6
SELECT title, rating FROM movies
ORDER BY rating;
#Consulta 7
SELECT title FROM movies LIMIT 3;
#Consulta 8
SELECT title FROM movies 
ORDER BY rating DESC
LIMIT 5;
#Consulta 9
SELECT CONCAT(first_name, " ", last_name) AS nombre_completo 
FROM actors
LIMIT 10; 
#Consulta 10
SELECT title, rating FROM movies
WHERE title = "Toy Story";
#Consulta 11
SELECT * FROM actors
WHERE first_name LIKE "Sam%";
#Consulta 12
SELECT * FROM movies
WHERE YEAR(release_date) BETWEEN 2004 AND 2008;
#Consulta 13
SELECT title FROM movies
WHERE rating>3
AND awards>1
AND YEAR(release_date) BETWEEN 1988 AND 2009;
