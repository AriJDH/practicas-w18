package com.meli.be_java_hisp_w18_g9.util;

import com.meli.be_java_hisp_w18_g9.model.dto.response.FollowersCountUserResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowedListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserFollowerListResponse;
import com.meli.be_java_hisp_w18_g9.model.dto.response.UserSimpleResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
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

    public static User addFollowed(User userMock, User userToFollow) {

        List<User> listUsers = userMock.getFollowed();
        listUsers.add(userToFollow);
        userMock.setFollowed(listUsers);

        return userMock;
    }

    public static User addFollower(User userToFollow, User userMock) {

        List<User> listUsers = userToFollow.getFollowers();
        listUsers.add(userMock);
        userToFollow.setFollowers(listUsers);

        return userToFollow;
    }

    public static UserFollowedListResponse getUserFollowedListResponse(User user, Integer order){

        UserFollowedListResponse userFollowedListResponse;

        switch (order)
        {
            /*Order desc*/
            case 1:
                userFollowedListResponse = new UserFollowedListResponse(user.getUserId(), user.getUserName(), user.getFollowed().stream()
                        .map(m -> new UserSimpleResponse(m.getUserId(), m.getUserName()))
                        .sorted(Comparator.comparing(UserSimpleResponse::getUserName).reversed())
                        .collect(Collectors.toList()));
                break;
            /*Order asc*/
            case 2:
                userFollowedListResponse = new UserFollowedListResponse(user.getUserId(), user.getUserName(), user.getFollowed().stream()
                        .map(m -> new UserSimpleResponse(m.getUserId(), m.getUserName()))
                        .sorted(Comparator.comparing(UserSimpleResponse::getUserName))
                        .collect(Collectors.toList()));
                break;
            /*Without order*/
            default:
                userFollowedListResponse = new UserFollowedListResponse(user.getUserId(), user.getUserName(), user.getFollowed().stream()
                        .map(m -> new UserSimpleResponse(m.getUserId(), m.getUserName()))
                        .collect(Collectors.toList()));
                break;

        }

        return userFollowedListResponse;
    }

    public static UserFollowerListResponse getUserFollowerListResponse(User user, Integer order){

        UserFollowerListResponse userFollowerListResponse;

        switch (order)
        {
            /*Order desc*/
            case 1:
                userFollowerListResponse = new UserFollowerListResponse(user.getUserId(), user.getUserName(), user.getFollowers().stream()
                        .map(m -> new UserSimpleResponse(m.getUserId(), m.getUserName()))
                        .sorted(Comparator.comparing(UserSimpleResponse::getUserName).reversed())
                        .collect(Collectors.toList()));
                break;
            /*Order asc*/
            case 2:
                userFollowerListResponse = new UserFollowerListResponse(user.getUserId(), user.getUserName(), user.getFollowers().stream()
                        .map(m -> new UserSimpleResponse(m.getUserId(), m.getUserName()))
                        .sorted(Comparator.comparing(UserSimpleResponse::getUserName))
                        .collect(Collectors.toList()));
                break;
            /*Without order*/
            default:
                userFollowerListResponse = new UserFollowerListResponse(user.getUserId(), user.getUserName(), user.getFollowers().stream()
                        .map(m -> new UserSimpleResponse(m.getUserId(), m.getUserName()))
                        .collect(Collectors.toList()));
                break;

        }


        return userFollowerListResponse;
    }

    public static User getUserById(Integer userId, String nombre, Boolean withProducts) {
        User user = new User(userId, nombre, new ArrayList<>(), new ArrayList<>(), withProducts ? getProduct() : new ArrayList<>());
        return user;
    }

    public static FollowersCountUserResponse getFollowersCountUserResponse(User user){

        Integer userFollowersQuantity = user.getFollowers().size();

        return new FollowersCountUserResponse(user.getUserId(),user.getUserName(),userFollowersQuantity);
    }

}
