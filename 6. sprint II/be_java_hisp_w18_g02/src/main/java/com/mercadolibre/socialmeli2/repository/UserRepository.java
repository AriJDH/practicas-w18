package com.mercadolibre.socialmeli2.repository;

import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.Product;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository{
    private Map<Integer, User> users;
    private static int nextPostId= 1;

    public UserRepository() {
        this.users = new HashMap<>();
        this.setUsers(this.loadUsers());
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public Map<Integer, User> loadUsers(){
        Map<Integer, User> users = new HashMap<>();
        User u1 = new User(1, "Juan Perez");
        User u2 = new User(2, "Maria Rodriguez");

        Product pr1 = new Product(1, "Mouse inalámbrico", "Acessorio",
                                "Logitech", "Negro", "Usa pila AA.");

        Product pr2 = new Product(2, "Bicicleta de montaña R26", "Rodado",
                "Winner", "Roja", "18 velocidades.");

        Post post1 = new Post(nextPostId++, LocalDate.now(),  1, 15.5, pr1);
        Post post2 = new Post(nextPostId++, LocalDate.now(),  2, 15999.99, pr2);

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

    @Override
    public User findById(Integer id) {
        return this.users.get(id);
    }

    @Override
    public List<User> getFollowers(Integer id) {
        List<User> res = new ArrayList<>();

        for(Map.Entry<Integer, User> entry : users.entrySet()) {
            Set<User> followed = entry.getValue().getFollowed();

            for(User u : followed ) {
                if(u.getId() == id) {
                    res.add(entry.getValue());
                }
            }

        }
        return res;
    }

    @Override
    public void createPost(Integer userId, Post newPost) {
        User user = findById(userId);
        if (user.getPosts()==null){
            user.setPosts(new ArrayList<Post>());
        }
        user.getPosts().add(newPost);
    }

    @Override
    public Integer getNextPostId() {
        return nextPostId++;
    }

    @Override
    public boolean existsById(Integer id) {
        return this.users.containsKey(id);
    }
}
