package com.meli.be_java_hisp_w18_g9.util;

import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UsersFactory {

    private static List<User> userList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();

    private static List<Product> getProduct(){
        productList.add(new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!"));
        productList.add(new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!"));
        productList.add(new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!"));

        return productList;
    }

    public static List<User> getUserList(){

        User user1 = new User(1, "Ariel", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Martin", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userList.add(user1);
        userList.add(user2);

        userList.add(new User(3, "User 3", new ArrayList<>(), new ArrayList<>(), getProduct()));
        userList.add(new User(4, "Charly", new ArrayList<>(), new ArrayList<>(), getProduct()));

        return userList;
    }

    public static User getUserById(Integer userId,String nombre, Boolean withProducts){
        User user = new User(userId, nombre, new ArrayList<>(), new ArrayList<>(), withProducts?getProduct():new ArrayList<>());
        return user;
    }

}
