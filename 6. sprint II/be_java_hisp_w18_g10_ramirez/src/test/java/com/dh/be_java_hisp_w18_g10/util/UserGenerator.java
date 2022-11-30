package com.dh.be_java_hisp_w18_g10.util;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.entity.User;

import java.util.Arrays;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowedListDTOres;
import com.dh.be_java_hisp_w18_g10.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dh.be_java_hisp_w18_g10.dto.response.PostDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.ProductDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.Product;
import com.dh.be_java_hisp_w18_g10.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class UserGenerator {

    public static UserFollowedListDTOres getUserFollowedListDTOresOrderNameAsc() {

        UserDTOres user1 = new UserDTOres(2, "A_user");
        UserDTOres user2 = new UserDTOres(3, "B_user");
        UserDTOres user3 = new UserDTOres(4, "C_user");

        UserFollowedListDTOres user = new UserFollowedListDTOres(1, "usuario1", new ArrayList<>(List.of(user1, user2, user3)));

        return user;
    }
    public static UserFollowedListDTOres getUserFollowedListDTOresOrderNameDes() {

        UserDTOres user1 = new UserDTOres(2, "A_user");
        UserDTOres user2 = new UserDTOres(3, "B_user");
        UserDTOres user3 = new UserDTOres(4, "C_user");

        UserFollowedListDTOres user = new UserFollowedListDTOres(1, "usuario1", new ArrayList<>(List.of(user3, user2, user1)));

        return user;
    }
    public static UserFollowedListDTOres getUserFollowedListDTOresDesordenado() {

        UserDTOres user1 = new UserDTOres(2, "B_user");
        UserDTOres user2 = new UserDTOres(3, "A_user");
        UserDTOres user3 = new UserDTOres(4, "C_user");

        UserFollowedListDTOres user = new UserFollowedListDTOres(1, "usuario1", new ArrayList<>(List.of(user1, user2, user3)));

        return user;
    }

    public static User getUserFollowedName() {

        User user = new User(1, "Usuario");

        User user1 = new User(2, "B_user");
        User user2 = new User(3, "A_user");
        User user3 = new User(4, "C_user");

        Map<Integer, User> followed = new HashMap<>();
        followed.put(user1.getUserId(), user1);
        followed.put(user2.getUserId(), user2);
        followed.put(user3.getUserId(), user3);

        user.setFollowed(followed);

        return user;
    }


    private static Map<Integer, User> users = new HashMap<Integer, User>();
    public static void loadUsers(){

        // crear usuarios
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("usuario1");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("usuario2");

        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("usuario3");

        User user4 = new User();
        user4.setUserId(4);
        user4.setUserName("usuario4");

        // crear a quien sigue el usuerio 1 y por quien es seguido a la vez
        Map<Integer, User> followedUsuer1 = new HashMap<Integer, User>();
        followedUsuer1.put(user2.getUserId(), user2);
        followedUsuer1.put(user3.getUserId(), user3);
        user1.setFollowed(followedUsuer1);
        user1.setFollowers(followedUsuer1);

        Map<Integer, User> followedUsuer2 = new HashMap<Integer, User>();
        followedUsuer2.put(user3.getUserId(), user3);
        followedUsuer2.put(user1.getUserId(), user1);
        user2.setFollowed(followedUsuer2);
        user2.setFollowers(followedUsuer2);

        Map<Integer, User> followedUsuer3 = new HashMap<Integer, User>();
        followedUsuer3.put(user2.getUserId(), user2);
        user3.setFollowed(followedUsuer3);

        user2.getPosts().put(getListPosts().get(0).getPost_id(),getListPosts().get(0));
        user2.getPosts().put(getListPosts().get(1).getPost_id(),getListPosts().get(1));
        user2.getPosts().put(getListPosts().get(2).getPost_id(),getListPosts().get(2));

        user4.getPosts().put(getListPosts().get(0).getPost_id(),getListPosts().get(0));
        user4.getPosts().put(getListPosts().get(1).getPost_id(),getListPosts().get(1));


        users.put(user1.getUserId(), user1);
        users.put(user2.getUserId(), user2);
        users.put(user3.getUserId(), user3);
        users.put(user4.getUserId(), user4);

    }
    public static User getUser(int id){
        return users.get(id);
    }
    private static List<Post> getListPosts(){

        LocalDate old = LocalDate.of(2000,12,12);
        LocalDate lastWeek = LocalDate.of(2022,LocalDate.now().getMonthValue(),
                LocalDate.now().getDayOfMonth() -5);
        Post post1 = new Post(2,4, old, getListProduct().get(0),23,340.00);
        Post post2 = new Post(2,5, lastWeek, getListProduct().get(1),4,456);
        Post post3 = new Post(2,6, LocalDate.now(),getListProduct().get(2),77,865);
        return List.of(post1,post2,post3);
    }
    private static List<Product> getListProduct(){
        Product product = new Product(1,"Buzo","Ropa","Nike","Gris","Para usar en invierno");
        Product product2 = new Product(1,"Pantalon","Ropa","Adida","Negro","Para usar en Otoño");
        Product product3 = new Product(1,"Remera","Ropa","Levis","Blanco","Para usar en Verano");

        return List.of(product,product2,product3);
    }
    public static UserPostsDTOres getUserPostsDTOresOrderByDateAsc(){
        UserPostsDTOres userPost = new UserPostsDTOres();
        userPost.setUser_id(1);

        ProductDTOres product = new ProductDTOres(1,"Remera","Ropa","Levis","Blanco","Para usar en Verano");
        ProductDTOres product2 = new ProductDTOres(1,"Pantalon","Ropa","Adida","Negro","Para usar en Otoño");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -5);
        LocalDate nowMinus5Days = c.getTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        PostDTOres post2 = new PostDTOres(2,5, nowMinus5Days.format(formatter), product2,4,456);
        PostDTOres post1 = new PostDTOres(2,6, LocalDate.now().format(formatter),product,77,865);
        List<PostDTOres> listPostDtoResOrderByAsc = List.of(post2,post1);

        userPost.setPosts(listPostDtoResOrderByAsc);
        return userPost;

    }

    public static UserPostsDTOres getUserPostsDTOresOrderByDateDesc(){
        UserPostsDTOres userPost = new UserPostsDTOres();
        userPost.setUser_id(1);

        ProductDTOres product = new ProductDTOres(1,"Remera","Ropa","Levis","Blanco","Para usar en Verano");
        ProductDTOres product2 = new ProductDTOres(1,"Pantalon","Ropa","Adida","Negro","Para usar en Otoño");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -5);
        LocalDate nowMinus5Days = c.getTime().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        PostDTOres post2 = new PostDTOres(2,5, nowMinus5Days.format(formatter), product2,4,456);
        PostDTOres post1 = new PostDTOres(2,6, LocalDate.now().format(formatter),product,77,865);
        List<PostDTOres> listPostDtoResOrderByAsc = List.of(post1,post2);

        userPost.setPosts(listPostDtoResOrderByAsc);
        return userPost;
    }

    public static User getUser(int id, String name){
        User newUser = new User(id, name);
        return newUser;
    }

    public static User getUserWithFollowersASC(){
        User newUser = new User(1, "Followed");
        newUser.getFollowers().put(2, getUser(2, "userB"));
        newUser.getFollowers().put(3, getUser(3, "userC"));
        return newUser;
    }

    public static User getUserWithFollowersDESC(){
        User newUser = new User(1, "Followed");
        newUser.getFollowers().put(2, getUser(3, "userC"));
        newUser.getFollowers().put(3, getUser(2, "userB"));
        return newUser;
    }

    public static UserFollowersListDTOres UserFollowersDTOResASC(){
        UserFollowersListDTOres userFollowersListDTOres = new UserFollowersListDTOres();
        userFollowersListDTOres.setUser_name("Followed");
        userFollowersListDTOres.setUser_id(1);
        UserDTOres follower1 = new UserDTOres(2, "userB");
        UserDTOres follower2 = new UserDTOres(3, "userC");
        userFollowersListDTOres.setFollowers(Arrays.asList(follower1, follower2));
        return userFollowersListDTOres;
    }

    public static UserFollowersListDTOres UserFollowersDTOGeneratorDESC(){
        UserFollowersListDTOres userFollowersListDTOres = new UserFollowersListDTOres();
        userFollowersListDTOres.setUser_name("Followed");
        userFollowersListDTOres.setUser_id(1);
        UserDTOres follower1 = new UserDTOres(3, "userC");
        UserDTOres follower2 = new UserDTOres(2, "userB");
        userFollowersListDTOres.setFollowers(Arrays.asList(follower1, follower2));
        return userFollowersListDTOres;
    }


}
