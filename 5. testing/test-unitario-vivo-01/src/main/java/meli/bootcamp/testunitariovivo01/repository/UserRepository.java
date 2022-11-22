package meli.bootcamp.testunitariovivo01.repository;

import meli.bootcamp.testunitariovivo01.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository
{
    private List<User> userList = new ArrayList<>();

    public UserRepository()
    {
        cargarLista();
    }
    @Override
    public List<User> obtenerTodos() {
        return userList;
    }

    @Override
    public User guardarUsuario(User user) {
        userList.add(user);
        return user;
    }

    private void cargarLista()
    {
        userList.add(new User("aaaaaa", "bbbbbb", 11));
        userList.add(new User("cccccc", "dddddd", 22));
        userList.add(new User("eeeeee", "ffffff", 33));
        userList.add(new User("gggggg", "hhhhhh", 44));
        userList.add(new User("iiiiii", "jjjjjj", 55));
    }
}
