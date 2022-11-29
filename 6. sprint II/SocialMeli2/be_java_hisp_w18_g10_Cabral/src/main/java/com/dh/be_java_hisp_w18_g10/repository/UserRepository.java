package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.Product;
import com.dh.be_java_hisp_w18_g10.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    private Map<Integer, User> users = new HashMap<Integer, User>();
    private Integer count = 0;
    public UserRepository() {
        loadUsers();
    }

    private void loadUsers(){

        User user1 = new User(1, "usuario1");
        User user2 = new User(2, "usuario2");
        User user3 = new User(3, "usuario3");
        User user4 = new User(4, "usuario4");

        // USER1 SIGUE A USUARIO 2 Y 3.
        user1.getFollowed().put(user2.getUserId(), user2);
        user1.getFollowed().put(user3.getUserId(), user3);

        user2.getFollowers().put(user1.getUserId(), user1);
        user3.getFollowers().put(user1.getUserId(), user1);

        user2.getFollowed().put(user3.getUserId(), user3);
        user3.getFollowers().put(user2.getUserId(), user2);

        user3.getFollowed().put(user2.getUserId(), user2);
        user2.getFollowers().put(user3.getUserId(), user3);

        user2.getPosts().put(getListPosts().get(0).getPost_id(),getListPosts().get(0));
        user2.getPosts().put(getListPosts().get(1).getPost_id(),getListPosts().get(1));
        user2.getPosts().put(getListPosts().get(2).getPost_id(),getListPosts().get(2));

        user3.getPosts().put(getListPosts().get(0).getPost_id(),getListPosts().get(0));
        user3.getPosts().put(getListPosts().get(1).getPost_id(),getListPosts().get(1));
        user3.getPosts().put(getListPosts().get(2).getPost_id(),getListPosts().get(2));

        user4.getPosts().put(getListPosts().get(0).getPost_id(),getListPosts().get(0));
        user4.getPosts().put(getListPosts().get(1).getPost_id(),getListPosts().get(1));
        user4.getPosts().put(getListPosts().get(2).getPost_id(),getListPosts().get(2));

        users.put(user1.getUserId(), user1);
        users.put(user2.getUserId(), user2);
        users.put(user3.getUserId(), user3);
        users.put(user4.getUserId(), user4);
    }

    @Override
    public User getUser(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    private List<Post> getListPosts(){

        LocalDate old = LocalDate.of(2000,12,12);
        LocalDate lastWeek = LocalDate.of(2022,11,14);
        Post post1 = new Post(2,4, old, getListProduct().get(0),23,340.00);
        Post post2 = new Post(2,5, lastWeek, getListProduct().get(1),4,456);
        Post post3 = new Post(2,6, LocalDate.now(),getListProduct().get(2),77,865);
        return List.of(post1,post2,post3);
    }
    private List<Product> getListProduct(){
        Product product = new Product(1,"Buzo","Ropa","Nike","Gris","Para usar en invierno");
        Product product2 = new Product(1,"Pantalon","Ropa","Adida","Negro","Para usar en Otoño");
        Product product3 = new Product(1,"Remera","Ropa","Levis","Blanco","Para usar en Verano");

        return List.of(product,product2,product3);
    }

    @Override
    public List<User> getUserFollowers(int id) {
        return users.get(id).getFollowers().values().stream().collect(Collectors.toList());
    }
}
