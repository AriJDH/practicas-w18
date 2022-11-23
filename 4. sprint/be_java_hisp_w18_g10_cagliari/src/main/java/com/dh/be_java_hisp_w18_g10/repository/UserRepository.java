package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.dto.response.UserDTOres;
import com.dh.be_java_hisp_w18_g10.entity.Post;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.exception.GenericException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{
    private Map<Integer, User> users = new HashMap<Integer, User>();
    public UserRepository() {
        loadUsers();
        loadUsersFollowers();
        loadUsersFollowed();
    }
    private void loadUsers(){
        for (int i = 1; i < 10; i++) {
            users.put(i, new User(i, "usuario_"+i));
        }
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

    @Override
    public List<User> getUsers(String order) {
        List<User> users = getUsers(order);
        return null;
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
    @Override
    public void sortUserListBy(List<User> userList, String order){
        switch(order){
            case "name_asc":
                userList.sort(Comparator.comparing(User::getUserName));
                break;
            case "name_desc":
                userList.sort(Comparator.comparing(User::getUserName).reversed());
                break;
            default:
                throw new GenericException("Parametro no aceptado");
        }
    }
    @Override
    public List<User> getUserFollowers(int userId, String order) {
        List<User> followers = getUserFollowers(userId);
        sortUserListBy(followers, order);
        return followers;
    }
    @Override
    public List<User> getUserFollowed(int userId) {
        return new ArrayList<>(getUser(userId).getFollowed().values());
    }
    @Override
    public List<User> getUserFollowed(int userId, String order) {
        List<User> followed = getUserFollowed(userId);
        sortUserListBy(followed, order);
        return followed;
    }
}
