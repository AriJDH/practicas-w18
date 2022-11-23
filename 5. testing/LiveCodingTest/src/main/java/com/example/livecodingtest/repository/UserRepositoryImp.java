package com.example.livecodingtest.repository;

import com.example.livecodingtest.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements IUserRepository{

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


    private void cargarLista(){
        listaUsuarios.add(new User("Jose","Perez", 32));
        listaUsuarios.add(new User("María", "Paz", 25));
        listaUsuarios.add(new User("Emilio", "Gonzales", 30));
    }
}
