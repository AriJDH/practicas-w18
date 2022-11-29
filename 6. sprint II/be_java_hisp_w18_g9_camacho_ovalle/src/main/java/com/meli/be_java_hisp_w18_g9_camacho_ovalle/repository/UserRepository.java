package com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository implements IUserRepository {

    // ? ================== Attributes ================== ?

    private static final Map<Integer, User> users = new HashMap<>();

    // ? ================== Methods ================== ?


    /**
     * Get all users
     * @return List<User>
     */
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    // * ===============

    /**
     * Get user by Id
     * @param id user to search
     * @return User
     */
    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    // * ===============

    /**
     * save a user
     * @param entity user to save
     */
    @Override
    public User save(User entity) {
        return users.put(entity.getUserId(), entity);
    }

    // * ===============

    /**
     * Delete a user
     * @param id user to delete
     */
    @Override
    public void deleteById(Integer id) {
        users.remove(id);
    }

    // * ===============

    /**
     * Update a user
     * @param entity user to update
     * @return id user to update
     */
    @Override
    public Integer update(User entity) {
        users.replace(entity.getUserId(),entity);
        return entity.getUserId();
    }

    // * ===============

}
