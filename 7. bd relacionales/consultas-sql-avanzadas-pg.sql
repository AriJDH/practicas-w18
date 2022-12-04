use movies_db;

select * from series;
select * from genres;

-- 1
select s.title, g.name as genre from series s
join genres g 
on g.id = s.genre_id;

-- 2
select e.title, a.first_name, a.last_name from actors a
join actor_episode a_e
on a.id = a_e.actor_id
join episodes e
on a_e.episode_id = e.id;

-- 3
select s.title, count(*) as temporadas from series s
join seasons sea 
on s.id = sea.serie_id
group by s.title;

-- 4
select g.name, count(*) as peliculas from genres g
left join movies m
on g.id = m.genre_id
group by g.name
having peliculas >= 3;

-- 5
select distinct a.first_name, a.last_name from actors a
join actor_movie a_m 
on a.id = a_m.actor_id
join movies m 
on a_m.movie_id = m.id
where m.title like "La Guerra%";
