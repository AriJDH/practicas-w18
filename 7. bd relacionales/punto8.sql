SELECT `movies`.`id`,
    `movies`.`created_at`,
    `movies`.`updated_at`,
    `movies`.`title`,
    `movies`.`rating`,
    `movies`.`awards`,
    `movies`.`release_date`,
    `movies`.`length`,
    `movies`.`genre_id`
FROM `movies_db`.`movies`
ORDER BY 'ratin' ASC
limit 5;
