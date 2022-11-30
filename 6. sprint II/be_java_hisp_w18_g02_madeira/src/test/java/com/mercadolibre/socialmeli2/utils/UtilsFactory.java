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

import static com.mercadolibre.socialmeli2.utils.Constants.*;

public class UtilsFactory {
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

        Post post1 = new Post(1, LocalDate.now(), 1, 15.5, pr1);
        Post post2 = new Post(2, LocalDate.now(), 2, 15999.99, pr2);

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

    public static Post postWithDate(LocalDate date){
        return new Post(1, date,  1, 1.0, new Product());
    }

    public static User userWithId(Integer id){
        return new User(id, "Juan Perez");
    }



    public static List<String> requiredFieldsMessages(){
        return Arrays.asList(USER_ID_REQUIRED,
                DATE_REQUIRED,
                CATEGORY_REQUIRED,
                PRICE_REQUIRED,
                PRODUCT_ID_REQUIRED,
                PRODUCT_NAME_REQUIRED,
                TYPE_REQUIRED,
                BRAND_REQUIRED,
                COLOR_REQUIRED);
    }

    public static List<String> regexPatternMessages(){
        return Arrays.asList(PRODUCT_NAME_SPECIAL_CHARACTERS_NOT_ALLOWED,
                TYPE_SPECIAL_CHARACTERS_NOT_ALLOWED,
                BRAND_SPECIAL_CHARACTERS_NOT_ALLOWED,
                COLOR_SPECIAL_CHARACTERS_NOT_ALLOWED,
                NOTES_SPECIAL_CHARACTERS_NOT_ALLOWED);
    }

    public static List<String> maxValidMessages(){
        return Arrays.asList(
                MAX_PRICE,
                PRODUCT_NAME_MAX_LENGTH_40,
                TYPE_MAX_LENGTH_15,
                BRAND_MAX_LENGTH_15,
                COLOR_MAX_LENGTH_15,
                MAX_LENGTH_80);
    }

    public static List<String> minValidMessages(){
        return Arrays.asList(
                        USER_ID_POSITIVE,
                        MIN_PRICE,
                        PRODUCT_ID_POSITIVE);
    }



}
