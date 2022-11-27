package com.test.pruebastesting.serivce;

import com.test.pruebastesting.dto.RolesDTO;
import com.test.pruebastesting.dto.UsuarioDTO;
import com.test.pruebastesting.entity.Roles;
import com.test.pruebastesting.entity.Usuario;

import java.util.List;

public interface IServiceGeneral {
    List<UsuarioDTO> getAllUsuarios();
    UsuarioDTO getUsuario(int id);
    List<RolesDTO> getAllRoles();
    RolesDTO getRole(int id);
    void crearUsuario(UsuarioDTO usuario);
}
