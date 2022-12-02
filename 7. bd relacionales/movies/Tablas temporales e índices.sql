USE movies_db;
#Ejercicio 1
CREATE TEMPORARY TABLE TWD(
`id` int(10),
`created_at` timestamp,
`updated_at` timestamp,
`title` varchar(500),
`number` int(10),
`release_Date` datetime,
`rating` decimal(3,1),
`season_id` int(10)
);

INSERT INTO TWD 
SELECT e.id, e.created_at, e.updated_at, e.title, e.number, e.release_date, e.rating, e.season_id
FROM episodes e INNER JOIN seasons sea INNER JOIN series se
WHERE e.season_id=sea.id 
	AND sea.serie_id=se.id
    AND se.title="The Walking Dead";

SELECT * FROM TWD;

#Ejercicio 2
CREATE INDEX index_serie_title ON series (title);

explain SELECT * FROM series
WHERE title="The Walking Dead";

##Sin índice esta consulta recorre 6 rows
##Con índce recorre solo 1