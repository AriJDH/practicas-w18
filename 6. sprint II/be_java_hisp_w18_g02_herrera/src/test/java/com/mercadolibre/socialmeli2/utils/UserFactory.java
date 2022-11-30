package com.mercadolibre.socialmeli2.utils;

import com.mercadolibre.socialmeli2.dto.response.UserDtoRes;
import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.Product;
import com.mercadolibre.socialmeli2.entity.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserFactory {
    public static List<User> getUsers() {
        User user1 = new User(2, "Camila");
        User user2 = new User(3, "Alberto");
        User user3 = new User(4, "Beto");

        return Arrays.asList(user1, user2, user3);
    }

    public static List<UserDtoRes> getUsersListDto(String order) {
        UserDtoRes camila = new UserDtoRes(2 , "Camila");
        UserDtoRes alberto = new UserDtoRes(3 , "Alberto");
        UserDtoRes beto = new UserDtoRes(4 , "Beto");

        if(order != null && order.equals("name_asc")) {
            return Arrays.asList(alberto, beto, camila);
        } else if(order != null && order.equals("name_desc")) {
            return Arrays.asList(camila, beto, alberto);
        } else {
            return Arrays.asList(camila, alberto, beto);
        }
    }

    public static Map<Integer, User> loadUsers() {
        Map<Integer, User> users = new HashMap<>();
        User u1 = new User(1, "Juan Perez");
        User u2 = new User(2, "Maria Rodriguez");

        Product pr1 = new Product(1, "Mouse inalámbrico", "Acessorio",
                "Logitech", "Negro", "Usa pila AA.");

        Product pr2 = new Product(2, "Bicicleta de montaña R26", "Rodado",
                "Winner", "Roja", "18 velocidades.");

        LocalDate now = LocalDate.now();

        Post post1 = new Post(1, now, 1, 15.5, pr1);
        Post post2 = new Post(2, now, 2, 15999.99, pr2);

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

    public static Map<Integer, User> loadUsersWithPosts() {
        Map<Integer, User> users = new HashMap<>();
        User u1 = new User(1, "Juan Perez");
        User u2 = new User(2, "Maria Rodriguez");

        Product pr1 = new Product(1, "Mouse inalámbrico", "Acessorio",
                "Logitech", "Negro", "Usa pila AA.");

        Product pr2 = new Product(2, "Bicicleta de montaña R26", "Rodado",
                "Winner", "Roja", "18 velocidades.");

        LocalDate now = LocalDate.now();
        LocalDate yesterday = now.minusDays(1);
        LocalDate fiveDaysAgo = now.minusDays(5);
        LocalDate eightDaysAgo = now.minusDays(8);
        LocalDate oneWeekAgo = now.minusWeeks(1);
        LocalDate twoWeeksAgo = now.minusWeeks(2);
        LocalDate threeWeeksAgo = now.minusWeeks(3);
        LocalDate fourWeeksAgo = now.minusWeeks(4);

        Post post1 = new Post(1, now, 1, 15.5, pr1);
        Post post2 = new Post(2, yesterday, 2, 15999.99, pr2);
        Post post3 = new Post(3, fiveDaysAgo, 3, 7000D, pr2);
        Post post4 = new Post(4, eightDaysAgo, 4, 5999D, pr2);
        Post post5 = new Post(5, oneWeekAgo, 5, 200D, pr2);

        Post post6 = new Post(6, twoWeeksAgo, 6, 47D, pr2);
        Post post7 = new Post(7, threeWeeksAgo, 7, 1200.5, pr2);
        Post post8 = new Post(8, fourWeeksAgo, 8, 1200.5, pr2);

        User u3 = new User(3, "LaOfertaPerfecta");
        User u4 = new User(4, "MotociclosSA");

        u3.addPost(post1);
        u3.addPost(post3);
        u3.addPost(post4);
        u3.addPost(post7);

        u4.addPost(post2);
        u4.addPost(post5);
        u4.addPost(post6);
        u4.addPost(post8);

        users.put(1, u1);
        users.put(2, u2);
        users.put(3, u3);
        users.put(4, u4);

        u1.addFollowed(u3);
        u1.addFollowed(u4);
        return users;
    }


    public static Map<Integer, User> loadAbcUsers(){
        Map<Integer, User> users = new HashMap<>();
        User u1 = new User(1, "Juan");

        User camila = new User(2, "Camila");
        User alberto = new User(3, "Alberto");
        User beto = new User(4, "Beto");

        Product pr1 = new Product(1, "Mouse inalámbrico", "Acessorio",
                "Logitech", "Negro", "Usa pila AA.");

        Product pr2 = new Product(2, "Bicicleta de montaña R26", "Rodado",
                "Winner", "Roja", "18 velocidades.");

        Product pr3 = new Product(3, "Otro producto", "tipo",
                "brand", "Roja", "18 velocidades.");

        Post post1 = new Post(1, LocalDate.now(),  1, 15.5, pr1);
        Post post2 = new Post(2, LocalDate.now(),  2, 15999.99, pr2);
        Post post3 = new Post(3, LocalDate.now(),  3, 8000D, pr3);

        camila.addPost(post1);
        alberto.addPost(post2);
        beto.addPost(post3);

        users.put(1, u1);
        users.put(2, camila);
        users.put(3, alberto);
        users.put(4, beto);

        u1.addFollowed(camila);
        u1.addFollowed(alberto);
        u1.addFollowed(beto);
        return users;
    }

    public static Post postWithDate(LocalDate date){
        return new Post(1, date,  1, 1.0, new Product());
    }

    public static User userWithId(Integer id){
        return new User(id, "Juan Perez");
    }


}
