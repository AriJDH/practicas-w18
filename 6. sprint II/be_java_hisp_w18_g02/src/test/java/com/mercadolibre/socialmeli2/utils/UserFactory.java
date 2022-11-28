package com.mercadolibre.socialmeli2.utils;

import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.Product;
import com.mercadolibre.socialmeli2.entity.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    public static Map<Integer, User> loadUsers(){
        Map<Integer, User> users = new HashMap<>();
        User u1 = new User(1, "Juan Perez");
        User u2 = new User(2, "Maria Rodriguez");

        Product pr1 = new Product(1, "Mouse inalámbrico", "Acessorio",
                "Logitech", "Negro", "Usa pila AA.");

        Product pr2 = new Product(2, "Bicicleta de montaña R26", "Rodado",
                "Winner", "Roja", "18 velocidades.");

        Post post1 = new Post(1, LocalDate.now(),  1, 15.5, pr1);
        Post post2 = new Post(2, LocalDate.now(),  2, 15999.99, pr2);

        User u3 = new User(3, "LaOfertaPerfecta");
        User u4 = new User(4, "MotociclosSA");

        u3.addPost(post1);
        u4.addPost(post2);

        users.put(1, u1);
        users.put(2, u2);
        users.put(3, u3);
        users.put(4, u4);

        u1.addFollowed(u3);
        u1.addFollowed(u4);
        return users;
    }
}
