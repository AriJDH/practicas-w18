
SELECT *
FROM movies;

SELECT first_name AS Nombre, last_name AS Apellido, rating AS Rating
FROM actors
ORDER BY first_name ASC;

SELECT title AS Título 
FROM series
ORDER BY title;

SELECT first_name AS Nombre, last_name AS Apellido
FROM actors
WHERE rating > 7.5
ORDER BY first_name ASC;

SELECT title AS Título, rating AS Rating, awards AS Premios
FROM movies
WHERE rating > 7.5 AND awards > 2
ORDER BY title;

SELECT title AS Título, rating AS Rating
FROM movies
ORDER BY rating;

SELECT title AS Título 
FROM movies
LIMIT 3;

SELECT title AS Título, rating AS Rating
FROM movies
ORDER BY rating DESC
LIMIT 5;

SELECT first_name AS Nombre, last_name AS Apellido
FROM actors
LIMIT 10;

SELECT title AS Título, rating AS Rating
FROM movies
WHERE title LIKE 'Toy Story%';

SELECT first_name AS nombre, last_name AS Apellido
FROM actors
WHERE first_name LIKE 'Sam%';

SELECT title AS Título, release_date AS "Fecha de lanzamiento"
FROM movies
WHERE release_date BETWEEN 20040101 AND 20081231;

SELECT title AS Título, rating AS Rating, awards AS Premios, release_date AS "Fecha de lanzamiento"
FROM movies
WHERE rating > 3 AND awards > 1 AND release_date BETWEEN 19880101 AND 20091231
ORDER BY title;






