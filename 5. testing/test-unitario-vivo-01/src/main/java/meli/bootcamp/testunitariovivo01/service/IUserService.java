package meli.bootcamp.testunitariovivo01.service;

import meli.bootcamp.testunitariovivo01.dto.UserDto;
import java.util.List;

public interface IUserService {
    UserDto crearUsuario(UserDto userDto);
    List<UserDto> obtenerTodos();
}
