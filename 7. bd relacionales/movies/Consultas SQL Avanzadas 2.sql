USE movies_db;

#Ejercicio 1
INSERT INTO movies (title,rating,awards,release_date,length)
VALUES ("Piratas del caribe", 10,1,"2008-10-10", 109);
#Ejercicio 2
INSERT INTO genres (name, ranking, active)
VALUES ("Aventura", 13, true);
#Ejercicio 3
UPDATE movies
SET genre_id=(SELECT id FROM genres WHERE name="Aventura" LIMIT 1)
WHERE id=22;
#Ejercicio 4
UPDATE actors
SET favorite_movie_id = 22
WHERE id=3;
#Ejercicio 5
CREATE TEMPORARY TABLE movies_temp(
id int(10),
created_at timestamp,
updated_at timestamp,
title varchar(500),
rating decimal(3,1),
awards int,
release_date datetime,
length int,
genre_id int
);

INSERT INTO movies_temp
SELECT * FROM movies;

SELECT * FROM movies_temp;
#Ejercicio 6
DELETE FROM movies_temp
WHERE awards>=5;

SELECT * FROM movies_temp;
#Ejercicio 7
SELECT DISTINCT g.name FROM genres g INNER JOIN movies m
WHERE g.id=m.genre_id;
#Ejercicio 8
SELECT CONCAT(a.first_name, " ", a.last_name) AS actor_name FROM actors a INNER JOIN movies m
WHERE a.favorite_movie_id=m.id AND m.awards>3;
#Ejercicio 9
CREATE INDEX index_movie_title ON movies (title);
DROP INDEX index_movie_title ON movies;
#Ejercicio 11
EXPLAIN SELECT * FROM movies WHERE title="Piratas del caribe";
#Sin el índice recorre 22 rows
#Con el índice recorre 1 row
#Ejercicio 12
#Podría crear un índice similar sobre el title de la tabla series