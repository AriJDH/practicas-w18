package com.example.livecoding.repository;

import com.example.livecoding.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements IUserRepository {
    private List<User> listaUsuarios;



    public UserRepositoryImp(){
        this.listaUsuarios = new ArrayList<>();
        cargarLista();
    }

    @Override
    public List<User> obtenerTodos() {
        return this.listaUsuarios;
    }

    @Override
    public User guardarUsuario(User user) {
        this.listaUsuarios.add(user);
        return user;
    }

    private void cargarLista(){
        this.listaUsuarios.add(new User("Jose", "Perez", 32));
        this.listaUsuarios.add(new User("Maria", "Paz", 29));
        this.listaUsuarios.add(new User("Martin", "Profe", 22));
    }

}
