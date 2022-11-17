package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    // ? ================== Attributes ================== ?

    private static final Map<Integer, User> users = new HashMap<>();

    static {

        List<Product> products = List.of(
                new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!"),
                new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!"),
                new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!")
        );

        User user1 = new User(1, "User 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "User 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        users.put(1, user1);
        users.put(2, user2);

        List<User> followers = List.of(user1, user2);
        List<User> followed = List.of(user1);

        users.put(3, new User(3, "User 3", new ArrayList<>(), new ArrayList<>(), products));
        users.put(2, new User(2, "User 2", new ArrayList<>(), followed, products));
    }


    // ? ================== Methods ================== ?

    @Override
    public List<User> findAll() {
        return users.values().stream().collect(Collectors.toList());
    }

    // * ===============

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    // * ===============

    @Override
    public User save(User entity) {
        return users.put(entity.getUserId(), entity);
    }

    // * ===============

    @Override
    public void deleteById(Integer id) {
        users.remove(id);
    }

    // * ===============

    @Override
    public Integer update(User entity) {
        users.replace(entity.getUserId(),entity);
        return entity.getUserId();
    }

    // * ===============

}
