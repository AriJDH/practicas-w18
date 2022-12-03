use movies_db;

/*Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.*/

CREATE TEMPORARY TABLE TWD(
id int not null primary key auto_increment,
episode_id int not null, 
title varchar(150) not null,
season_id int not null
);

/*Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.*/
insert into TWD (episode_id, title, season_id) 
SELECT id, title, season_id FROM movies_db.episodes WHERE season_id in (
SELECT id FROM movies_db.seasons WHERE serie_id = (SELECT id FROM movies_db.series WHERE title = 'The Walking Dead'));

select * from TWD;

/*Agregar un género a la tabla genres.*/
INSERT INTO `movies_db`.`genres`
(`created_at`,`updated_at`,`name`,`ranking`,`active`)
VALUES
(null,null,'Shonen',14,1);


/*Agregar una película a la tabla movies.*/
/*Asociar a la película del punto 1. con el género creado en el punto 2.*/
INSERT INTO `movies_db`.`movies`
(`created_at`,`updated_at`,`title`,`rating`,`awards`,`release_date`,`length`,`genre_id`)
VALUES
(null,null,'Dragon ball super super heroes',8.0,10,CURDATE(),120,(SELECT id FROM movies_db.genres WHERE name = 'Shonen'));

/*Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.*/
UPDATE movies_db.actors set favorite_movie_id = (SELECT id FROM movies_db.movies WHERE title = 'Dragon ball super super heroes') 
WHERE favorite_movie_id is null; 

/*Crear una tabla temporal copia de la tabla movies.*/
CREATE TEMPORARY TABLE movies_temp(
id int not null primary key auto_increment,
movie_id int not null,
created_at timestamp,
update_at timestamp,
title varchar(500),
rating decimal(3,1),
awards int,
release_date datetime,
length int,
genre_id int 
);

INSERT INTO movies_temp (movie_id, created_at, update_at, title ,rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title ,rating, awards, release_date, length, genre_id
FROM movies_db.movies;

/*Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.*/
SELECT * FROM movies_temp;
DELETE FROM movies_temp WHERE awards < 5;

/*Obtener la lista de todos los géneros que tengan al menos una película.*/
SELECT distinct(name) genre FROM movies_db.genres g 
INNER JOIN movies_db.movies_temp m on m.genre_id = g.id;

/*Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.*/
SELECT a.first_name FROM movies_db.actor_movie am
INNER JOIN movies_db.movies_temp m on m.id = am.movie_id
INNER JOIN movies_db.actors a on a.id = am.actor_id
WHERE m.awards > 3;

/*Crear un índice sobre el nombre en la tabla movies.*/
CREATE INDEX inx_length ON movies_db.movies (length); 

/*Chequee que el índice fue creado correctamente.*/
SHOW INDEX FROM movies_db.movies;
