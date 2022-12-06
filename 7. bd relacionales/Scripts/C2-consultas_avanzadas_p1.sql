use movies_db; 

select * from actors;
select * from movies;


use empresa; 


#GROUP BY
-- con bd movies
SELECT 
	COUNT(*), 
    movies.title, 
    movies.rating, 
    movies.awards
FROM movies 
INNER JOIN actors
ON movies.id = actors.favorite_movie_id
GROUP BY title;


# HAVING
-- con bd empresa
SELECT dni, SUM(pago) as total
FROM clientes_pagos
GROUP BY dni
HAVING total > 2500;

-- Orden de ejecución y diferentia entre cláusulas
-- Se desea obtener sólo las personas que realizaron pagos por un total superior a 100 GROUP BY dni HAVING SUM(pago) > 100 
-- pero considerando 
-- que cada compra indivudaL haya sido superior a 50 (WHERE pago > 50)

SELECT dni, SUM(pago) as total
FROM clientes_pagos
WHERE pago > 50
GROUP BY dni
HAVING total > 2000;



# --con bd movies
SELECT COUNT(*) tot_act, 
    mo.title,
    mo.rating,
    mo.awards
FROM movies mo
INNER JOIN actors ac
ON mo.id = ac.favorite_movie_id
GROUP BY title
HAVING tot_act > 2; 



