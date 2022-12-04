create TEMPORARY table TDW
(
    id         int unsigned auto_increment
        primary key,
    created_at timestamp            null,
    updated_at timestamp            null,
    name       varchar(100)         not null,
    ranking    int unsigned         not null,
    active     tinyint(1) default 1 not null,
    constraint genres_ranking_unique
        unique (ranking)
)

