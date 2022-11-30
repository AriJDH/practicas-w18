package com.meli.be_java_hisp_w18_g9.util;

import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserSimpleResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersFactory {

    private static List<User> userList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();

    private static List<Product> getProduct() {
        productList.add(new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!"));
        productList.add(new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!"));
        productList.add(new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!"));

        return productList;
    }

    private static List<User> getFollowed(Integer id) {
        userList.add(new User(id+1, "Martin", new ArrayList<>(), new ArrayList<>(), getProduct()));
        userList.add(new User(id+2, "German", new ArrayList<>(), new ArrayList<>(), getProduct()));
        userList.add(new User(id+3, "Yolin", new ArrayList<>(), new ArrayList<>(), getProduct()));

        return userList;
    }

    private static List<User> getFollowers(Integer id) {
        userList.add(new User(id+1, "Yolanda", new ArrayList<>(), new ArrayList<>(), getProduct()));
        userList.add(new User(id+2, "Ezequiel", new ArrayList<>(), new ArrayList<>(), getProduct()));
        userList.add(new User(id+3, "Tormenta", new ArrayList<>(), new ArrayList<>(), getProduct()));

        return userList;
    }

    public static User getUserWithAllList(Integer userId, String nombre, Boolean products, boolean followeds, boolean followers) {

        User userToReturn = new User(userId, nombre, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        if (products) {
            userToReturn.setProducts(getProduct());
        }

        if (followeds) {
            userToReturn.setFollowed(getFollowed(userId));
        }

        if (followers) {
            userToReturn.setFollowers(getFollowers(userId));
        }

        return userToReturn;
    }

    public static UserFollowedListResponse getUserFollowedListResponse(User user){
        return new UserFollowedListResponse(user.getUserId(), user.getUserName(), user.getFollowed().stream()
                .map(m -> new UserSimpleResponse(m.getUserId(), m.getUserName()))
                .collect(Collectors.toList()));
    }

    public static UserFollowerListResponse getUserFollowersListResponse(User user){
        return new UserFollowerListResponse(user.getUserId(), user.getUserName(), user.getFollowers().stream()
                .map(m -> new UserSimpleResponse(m.getUserId(), m.getUserName()))
                .collect(Collectors.toList()));
    }
    public static FollowersCountUserResponse getFollowersCountUserResponse(User user){
        return new FollowersCountUserResponse(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

    public static User getUserById(Integer userId, String nombre, Boolean withProducts) {
        User user = new User(userId, nombre, new ArrayList<>(), new ArrayList<>(), withProducts ? getProduct() : new ArrayList<>());
        return user;
    }

}
