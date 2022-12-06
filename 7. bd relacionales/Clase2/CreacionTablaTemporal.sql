# EJERCICIO 1
# 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada 
# “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
create temporary table if not exists TWD
select epi.* from series ser
inner join seasons sea on sea.serie_id = ser.id
inner join episodes epi on epi.season_id = sea.id
where ser.title = "The Walking Dead";

drop table TWD;

# 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select t.*
from TWD t
inner join seasons s on s.id=t.season_id
where s.number = 1;
 ---------------------------------------------------------------------------------------------------
# EJERCICIO 2
# 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y 
# luego chequear la creación del mismo. 
alter table movies
add index idx_rating (rating) visible;

show index from movies;
















