INSERT INTO `rol`(`id`, `rol`)
values (1, 'BUYER'),
       (2, 'SUPERVISOR');

INSERT INTO `users`(`id`, `username`, `password`)
values (1, 'buyer1', '123'),
       (2, 'adminCentral', '123'),
       (3, 'adminUruguay', '123');

INSERT INTO `users_roles`(`user_id`, `roles_id`)
values (1, 1),
       (2, 2),
       (3, 2);

INSERT INTO `buyers` (`id`, `user_id`)
values (1, 1);

INSERT INTO `products` (`id`, `name`, `price`)
values  (1, 'Leche', 120.45),
        (2, 'Manteca', 156.00),
        (3, 'Levadura', 89.15);

INSERT INTO `purchases` (`id`, `date`, `order_status`, `buyer_id`)
values  (1, '2022-12-23', 'carrito', 1);

INSERT INTO `purchases_products` (`purchase_id`, `products_id`)
values (1, 1),
       (1, 2),
       (1, 3);

INSERT INTO `warehouses` (`id`, `name`)
values (1, 'Central'),
       (2, 'Uruguay');

INSERT INTO `sections` (`id`, `cod`, `name`, `temp_min`, `warehouse_id` )
values (1, 1, 'Frescos' , 5, 1),
       (2, 2, 'Refrigerados', 2, 1),
       (3, 3, 'Congelados', -2, 1);

INSERT INTO `supervisors` (`id`, `user_id` , `warehouse_id` )
values (1, 2, 1),
       (2, 3, 2);

INSERT INTO `inbound_orders` (`id`, `order_number`, `order_date`, `section_id`)
values (1, 1, '2022-12-26', 1);

INSERT INTO `batches` ( `id`, `batch_number`, `product_id`, `current_temperature`, `minimum_temperature`, `initial_quantity`, `current_quantity`,
    `manufacturing_date`, `manufacturing_time`, `due_date`, `inbound_id`)
values (1, 100 , 1, 2, 0, 50, 50, '2022-12-26', '2022-12-26 10:00:00', '2023-02-10', 1 ),
       (2, 200 ,2, 1, 0, 100, 100, '2022-12-26', '2022-12-26 10:00:00', '2023-02-10', 1 );





