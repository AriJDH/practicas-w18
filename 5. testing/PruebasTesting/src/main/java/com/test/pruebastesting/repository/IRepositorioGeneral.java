package com.test.pruebastesting.repository;

import com.test.pruebastesting.entity.Roles;
import com.test.pruebastesting.entity.Usuario;

import java.util.List;

public interface IRepositorioGeneral {
    List<Usuario> getAllUsuarios();
    Usuario getUsuario(int id);
    List<Roles> getAllRoles();
    Roles getRole(int id);
}
