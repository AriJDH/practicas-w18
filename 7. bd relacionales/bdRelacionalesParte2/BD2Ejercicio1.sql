use movies_db;

create temporary table TWD
select e.* from episodes e
inner join seasons s
on e.season_id = s.id
inner join series ss
on s.serie_id = ss.id
where ss.title like 'The Walking Dead';

select * from TWD;