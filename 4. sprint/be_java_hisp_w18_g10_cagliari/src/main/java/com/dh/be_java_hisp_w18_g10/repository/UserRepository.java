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

    public UserRepository() {
        loadUsers();
        loadUsersFollowers();
        loadUsersFollowed();
    }
    private void loadUsersFollowers(){
        for (int i = 2; i < 4; i++) {
            users
                .get(1)
                .getFollowers()
                .put(i, users.get(i));
            users
                .get(2)
                .getFollowers()
                .put(i+1, users.get(i+1));

        }
    }
    private void loadUsers(){
        for (int i = 1; i < 10; i++) {
            users.put(i, new User(i, "usuario_"+i));
        }
    }
    private void loadUsersFollowed(){
        for (int i = 2; i < 4; i++) {
            users
                    .get(4)
                    .getFollowed()
                    .put(i, users.get(i));
            users
                    .get(1)
                    .getFollowed()
                    .put(i+2, users.get(i+2));
        }
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
        Post post1 = new Post(2,4, old, getListProduct().get(0), 23,340.00, false, 0);
        Post post2 = new Post(2,5, lastWeek, getListProduct().get(1),4,456, false, 0);
        Post post3 = new Post(2,6, LocalDate.now(),getListProduct().get(2),77,865, false, 0);
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
        return new ArrayList<>(users.get(id).getFollowers().values()) ;
    }

    @Override
    public int countUserPromoPosts(int userId) {
        return (int) getUserPosts(userId)
                .stream()
                .filter(Post::isHasPromo)
                .count();
    }

    @Override
    public List<Post> getUserPosts(int userId) {
        return new ArrayList<>(users.get(userId).getPosts().values());
    }

    @Override
    public List<Post> getPromoPostByUser(int userId) {
        return getUserPosts(userId)
                .stream()
                .filter(Post::isHasPromo)
                .collect(Collectors.toList());
    }

}
