INSERT INTO `rol`(`id`, `rol`)
values (1, 'BUYER'),
       (2, 'ADMIN');

INSERT INTO `users`(`id`, `username`, `password`)
values (1, 'marco', 'calle falsa 123');

INSERT INTO `users_roles`(`user_id`, `roles_id`)
values (1, 1),
       (1, 2);
