package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.exception.NoFoundUserException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> users = new ArrayList<User>();

    public UserRepository() {
        addUsers();
    }

    private void addUsers() {
        User Gabriela = new User(1,"Gabriela",new ArrayList<>(),new ArrayList<>());
        User Dizzi = new User(2,"Dizzi",new ArrayList<>(),new ArrayList<>());
        User Juan_Pablo = new User(3,"Juan_Pablo",new ArrayList<>(),new ArrayList<>());
        User Julian = new User(4,"Julian",new ArrayList<>(),new ArrayList<>());
        User Jhonier = new User(5,"Jhonier",new ArrayList<>(),new ArrayList<>());
        User Angel = new User(5,"Angel",new ArrayList<>(),new ArrayList<>());
        users.add(Gabriela);
        users.add(Dizzi);
        users.add(Juan_Pablo);
        users.add(Julian);
        users.add(Jhonier);
        users.add(Angel);
    }

    public User findById(int userid) {
        return users.get(userid);
    }
    public List<User> selectAll() {
        return users;
    }
    public void removeFollower(int idUser, int idFollower) {
    }
    public void addFollower(int idUser, int idFollower) {
        User userFollower = users.stream().filter(u -> u.getUserId().equals(idFollower)).findFirst().get();
        User userToFollow = users.stream().filter(u -> u.getUserId().equals(idUser)).findFirst().get();

        if(userToFollow == null || userFollower == null){
            throw new NoFoundUserException("User id not found");
        }
        userToFollow.getListFollowers().add(userFollower);
    }
    public void removeFollowed(int idUser, int idFollowed) {

    }
    public void addFollowed(int idUser, int idFollowed) {

    }
}