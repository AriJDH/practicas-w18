package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository implements IUserRepository {

    // ? ================== Attributes ================== ?

    private static final Map<Integer, User> users = new HashMap<>();

    static {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!"));
        products.add(new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!"));
        products.add(new Product(3, "Notebook Asus", "Notebook", "Asus", "White", "Excelent!"));

        User user1 = new User(1, "Zonia", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Pedro", new ArrayList<>(), new ArrayList<>(), products);
        User user3 = new User(123, "Janeth",new ArrayList<>() , new ArrayList<>(), products);

        users.put(1, user1);
        users.put(2, user2);

        users.put(3, new User(3, "User 3", new ArrayList<>(), new ArrayList<>(), products));
        users.put(4, new User(4, "Charly", new ArrayList<>(), new ArrayList<>(), products));
        users.put(123, user3);

    }


    // ? ================== Methods ================== ?

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
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
