package com.test.democodingtest.repository;

import com.test.democodingtest.entity.User;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements IUserRepository {
    private List<User> listaUsuarios = new ArrayList<>();

    public UserRepositoryImp(){
        cargarLista();
    }


    @Override
    public List<User> obtenerTodos() {
        return listaUsuarios;
    }

    @Override
    public User guardarUsuario(User user) {
        listaUsuarios.add(user);
        return user;
    }

    @Override
    public Optional<User> buscarUsuarioPorNombre(String name) {
        Optional<User> userEncontrado = listaUsuarios.stream()
                .filter(user -> user.getNombre().equals(name))
                .findFirst();
        return userEncontrado;
    }


    private void cargarLista(){
        listaUsuarios.add(new User("jose","peres",32));
        listaUsuarios.add(new User("maria","paz",25));
        listaUsuarios.add(new User("Emilio","gonzalez",30));
    }
}
