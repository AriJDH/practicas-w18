use movies_db; 

# Creamos tabla temporal para almacenar el resultado de la siguiente consulta: 

SELECT actors.first_name, actors.last_name
FROM movies
JOIN actor_movie ON (movies.id = actor_movie.id)
JOIN genres ON (movies.genre_id = genres.id)
JOIN actors ON (actors.id = actor_movie.id)
WHERE movies.title LIKE '%Harry%'
GROUP BY actors.first_name;

# CREATE TEMPORARY TABLE <NOMBRE de nuestra tabla temporal>
# INSERT INTO <NOMBRE de nuestra tabla temporal>

CREATE TEMPORARY TABLE HarryTT (nombreActor varchar (40), apellidoActor varchar(40));

#Insertamos los datos a partir de una consulta
INSERT INTO HarryTT SELECT actors.first_name, actors.last_name
FROM movies
JOIN actor_movie ON (movies.id = actor_movie.id)
JOIN genres ON (movies.genre_id = genres.id)
JOIN actors ON (actors.id = actor_movie.id)
WHERE movies.title LIKE '%Harry%'
GROUP BY actors.first_name;

# Mostramos la columna apellidoActor que se creo para la tabla temporal HarryTT
SELECT apellidoActor FROM HarryTT;



###############################################################

# OPTIMIZACION DE BASES DE DATOS PARTE 2 - VIVO

/* Ejercicio 1
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.*/

use movies_db;


CREATE TEMPORARY TABLE TWD2
    SELECT episodes.*, series.title as title_series, seasons.number as seasons_number
    FROM series
    JOIN seasons
    ON  series.id = seasons.serie_id
    JOIN episodes
    ON seasons.id = episodes.season_id
    WHERE series.title like 'The Walking Dead';

SELECT * FROM TWD2 WHERE seasons_number = 1;


##############################################################

# ÍNDICES
/*
Permiten realizar búsquedas con mayor rapidez
El problema que tienen es que no son un estándar SQL por lo que cada gestor de BD tendrá su propia sintaxis. 

Tipos de índices: 
    - indice de clave primaria > Cada valor es ÚNICO - No Null
        ALTER TABLE <nombreTabla> ADD PRIMARY KEY (nombreAtributoQueSeraPK, otroAtributoPK) -> indice con PK compuesta
        
    - indices ordinarios > Pemite duplicados - Si NULL
        Parece un campo normal pero nos permitirá realizar búsquedas de forma más rápida. 
        Ejemplo creamos un índice ordinario en el campo apellido de la tablaEjemplo
        
        
        CREATE INDEX <nombreÍndice> ON <nombreTabla> (<campoDeLaTablaParaIndice)
        CREATE INDEX miIndice ON tablaEjemplo (apellido);
            
            
            
    - índices únicos > No permite duplicados (no se puede repetir la información de este campo en diferentes registros) - Si Null
        Similar los índices ordinarios pero NO permite duplicados
        
        CREATE UNIQUE INDEX <nombreINDICE> ON <nombreTabla> (<campoDeLaTablaParaIndice>)
    
    
    - índices compuestos > Múltiples columnas - Si Null - No permite duplicados en los campos que funcionan como índice
        
         CREATE UNIQUE INDEX <nombreINDICE> ON <nombreTabla> (<campoDeLaTablaParaIndice, otroCampo>) 
        
        
PARA ELIMINAR LOS ÍNDICES: 
    DROP INDEX <nombreIndice> ON <nombreTabla>
    
*/



--  EXPLAIN
EXPLAIN select * from movies WHERE id = 4; 

# Crear indice en un campo
# CREATE INDEX <nombreIndice> ON <nombreTabla> (<nombreCampo>);
SELECT * FROM movies WHERE awards > 5;
EXPLAIN SELECT * FROM movies WHERE awards > 5;

CREATE INDEX awards_idx ON movies (awards);


EXPLAIN select * from movies WHERE length=120;
select * from movies WHERE length=120;

