package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.User;
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
    User Gabriela = new User(
      1,
      "Gabriela",
      new ArrayList<>(),
      new ArrayList<>()
    );
    User Dizzi = new User(2, "Dizzi", new ArrayList<>(), new ArrayList<>());
    User Juan_Pablo = new User(
      3,
      "Juan_Pablo",
      new ArrayList<>(),
      new ArrayList<>()
    );

    List<User> userList = new ArrayList<>();

    userList.add(Gabriela);
    userList.add(Juan_Pablo);
    userList.add(Dizzi);

    List<User> userListFollowed = new ArrayList<>();

    userListFollowed.add(Gabriela);
    userListFollowed.add(Juan_Pablo);
    userListFollowed.add(Dizzi);

    User Julian = new User(4, "Julian", new ArrayList<>(), new ArrayList<>());
    User Jhonier = new User(5, "Jhonier", new ArrayList<>(), new ArrayList<>());
    User Angel = new User(6, "Angel", userListFollowed, userList);
    users.add(Gabriela);
    users.add(Dizzi);
    users.add(Juan_Pablo);
    users.add(Julian);
    users.add(Jhonier);
    users.add(Angel);
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

  public void removeFollower(int idUser, int idFollower) {}

  public void addFollower(int idUser, int idFollower) {}

  public void removeFollowed(int idUser, int idFollowed) {}

  public void addFollowed(int idUser, int idFollowed) {}
}
