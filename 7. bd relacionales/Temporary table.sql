create temporary table TWD(
titulo varchar(45),
genero varchar(45),
temporada int,
release_date datetime
);

drop table TWD;

select * from TWD;

drop table if exists TWD;
create temporary table TWD 
select episodes.title, episodes.rating, seasons.title as season, genres.name 
from series 
inner join seasons on series.id = seasons.serie_id 
inner join episodes on episodes.season_id = seasons.id 
inner join genres on  genres.id = series.genre_id
where series.title='The Walking Dead';



