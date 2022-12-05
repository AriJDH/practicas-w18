-- Agregar una película a la tabla movies.
insert into movies values (22, null, null, "batman", 3.5, 0, "2010-09-12", 120, 8);

-- Agregar un género a la tabla genres.
insert into genres values (13, null, null, "Superheroes", 13, 1);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
update movies set genre_id = 13 where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actor_movie set movie_id = 22 where id = 1;

-- Crear una tabla temporal copia de la tabla movies.

CREATE table temp_movies (
	id INT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    title VARCHAR(500),
    rating DECIMAL(3,1),
    awards INT,
    release_date DATETIME,
    length INT,
    genre_id INT
);

INSERT INTO TEMP_MOVIES SELECT * FROM MOVIES;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name, count(*) as cantidad_peliculas FROM genres g 
INNER JOIN movies m on m.genre_id = g.id group by g.name having cantidad_peliculas >= 1;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select * from actor_movie am inner join actors act on act.id = am.actor_id
inner join movies m on m.id = am.movie_id where m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
create index indice_nombre 
on movies (title);

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- mejoraria notablemente si se manejara una cantidad de información que requiriera una mejor rapidez

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- en la tabla de genero en su nombre para aguilizar la busquedas y evitar buscar entre todas las series o movies que se tiene, al
-- ser usada en las dos y que no se actualizara muy seguido