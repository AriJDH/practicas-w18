package com.test.pruebastesting.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.pruebastesting.entity.Roles;
import com.test.pruebastesting.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositorioGeneral implements IRepositorioGeneral{
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Roles> listaRoles = new ArrayList<>();

    public RepositorioGeneral(){
        this.crearDatos();
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return listaUsuarios;
    }

    @Override
    public Usuario getUsuario(int id) {
        return listaUsuarios.stream().filter(u -> u.getId() == id)
                .findFirst().get();
    }

    @Override
    public List<Roles> getAllRoles() {
        return listaRoles;
    }

    @Override
    public Roles getRole(int id) {
        return listaRoles.stream()
                .filter(r -> r.getId() == id)
                .findFirst().get();
    }

    private void crearDatos(){
        listaRoles.add(new Roles(1, "Admin"));
        listaRoles.add(new Roles(2,"Common"));

        listaUsuarios.add(new Usuario(1,"Jose",listaRoles.get(0)));
        listaUsuarios.add(new Usuario(2,"Manuel",listaRoles.get(1)));
    }
}
