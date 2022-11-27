package com.test.pruebastesting.serivce;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.pruebastesting.dto.RolesDTO;
import com.test.pruebastesting.dto.UsuarioDTO;
import com.test.pruebastesting.entity.Usuario;
import com.test.pruebastesting.exceptions.ExcepcionesGenerales;
import com.test.pruebastesting.repository.IRepositorioGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceGeneralImplmentacion implements IServiceGeneral{
    @Autowired
    private IRepositorioGeneral repository;

    private ObjectMapper mapper;

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        //mapper.convertValue(listaUsuariosRepo, new TypeReference<List<UserDto>>(){});
        List<UsuarioDTO> listaUsuarioDTO = getMapper().convertValue(repository.getAllUsuarios(),
                new TypeReference<List<UsuarioDTO>>(){});
        return listaUsuarioDTO;
    }

    @Override
    public UsuarioDTO getUsuario(int id) {
        Usuario usuario = repository.getUsuario(id);
        if(usuario == null)
            throw new ExcepcionesGenerales("No se encontro usuario");
        UsuarioDTO usuarioDTO = getMapper().convertValue(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }

    @Override
    public List<RolesDTO> getAllRoles() {
        return null;
    }

    @Override
    public RolesDTO getRole(int id) {
        return null;
    }

    @Override
    public void crearUsuario(UsuarioDTO usuario) {

    }

    private ObjectMapper getMapper(){
        if (mapper == null)
            return mapper = new ObjectMapper();
        return mapper;
    }
}
