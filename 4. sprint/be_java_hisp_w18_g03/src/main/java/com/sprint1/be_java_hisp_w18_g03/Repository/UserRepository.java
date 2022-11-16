package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.exception.NoFoundUserException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

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
        User Angel = new User(6,"Angel",new ArrayList<>(),new ArrayList<>());
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

  public User findById(Integer userid) {
    return users
      .stream()
      .filter(x -> x.getUserId().equals(userid))
      .findAny()
      .orElse(null);
  }

    public List<User> selectAll() {
        return users;
    }
    public void removeFollower(int idUser, int idFollower) {
    }
    public boolean addFollower(int idUser, int idUserToFollow) {
        // Se obtienen los usuarios con el metodo findByID
        User user = findById(idUser);
        User userToFollow = findById(idUserToFollow);

        if(user == null || userToFollow == null) {
            return false;
        }

        // Se agrega en la lista de seguidos del usuario
        user.getListFollowed().add(userToFollow);
        // Se agrega en la lista de seguidores del usuario a seguir.
        userToFollow.getListFollowers().add(user);

        return true;
    }
    public void removeFollowed(int idUser, int idFollowed) {

  public void addFollowed(int idUser, int idFollowed) {}
}
