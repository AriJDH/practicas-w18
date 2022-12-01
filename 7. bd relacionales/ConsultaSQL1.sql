-- Ej1
SELECT * FROM movies;

SELECT first_name, last_name, rating
FROM actors;

SELECT title AS titulo
FROM series;

SELECT first_name, last_name
FROM actors
WHERE rating > 7.5;

SELECT title, rating, awards
FROM movies
WHERE rating > 7.5
AND awards > 2;

SELECT title, rating
FROM movies
ORDER BY rating ASC;

SELECT title
FROM movies
LIMIT 3;

SELECT title, rating
FROM movies
ORDER BY rating desc
LIMIT 5;

SELECT *
FROM actors
LIMIT 10;

SELECT title, rating
FROM movies
WHERE title LIKE '%Toy Story%';

SELECT first_name, last_name
FROM actors
WHERE first_name LIKE '%Sam%';

SELECT title
FROM movies
WHERE release_date > '2004-01-01'
AND release_date < '2008-01-01';

SELECT title
FROM movies
WHERE rating > 3
AND awards > 1
AND release_date > '1988-01-01'
AND release_date < '2009-01-01'
ORDER BY rating;