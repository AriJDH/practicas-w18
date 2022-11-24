package com.survive.livecoding.repository;

import com.survive.livecoding.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements IUserRepository{

    private final List<User> userList;

    public UserRepositoryImp(List<User> userList) {
        this.userList = userList;
        loadList();
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public List<User> addUser(User user) {
        userList.add(user);
        return userList;
    }

    @Override
    public Optional<User> findUser(String userName) {
        return userList.stream()
                .filter(user -> user.getName().equals(userName))
                .findFirst();
    }

    private void loadList() {
        userList.add(new User("Frutas", "Fulano", 24));
        userList.add(new User("Verduras", "Mengano", 18));
        userList.add(new User("Carnes", "Mumino", 73));
    }


}
