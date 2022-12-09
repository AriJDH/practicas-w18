-- _Ejercicio 1_
-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.


USE movies_db;
DROP TEMPORARY TABLE IF EXISTS TWD;

CREATE TEMPORARY TABLE TWD
SELECT e.title, s.number
FROM  seasons s
INNER JOIN series se
ON s.serie_id = se.id
INNER JOIN episodes e
ON e.season_id = s.id
WHERE se.title LIKE 'The Walking Dead';

-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT *
FROM TWD
WHERE number = 1;

-- _Ejercicio 2_
-- 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 

ALTER TABLE users
ADD INDEX email_idx
(email);

SHOW INDEX FROM users;

-- 2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- RTA: Es probable que el email se utilice para identificar al usuario por lo que seguramente la tabla sería consultada muchas veces a través del campo email.
