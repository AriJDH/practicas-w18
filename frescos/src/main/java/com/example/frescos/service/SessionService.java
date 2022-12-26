package com.example.frescos.service;

import com.example.frescos.dtos.ApplicationUserRequestDTO;
import com.example.frescos.dtos.ApplicationUserResponseDTO;
import com.example.frescos.exception.UserNotFoundException;

public interface SessionService {
    /**
     * Realiza la validación del usuario y contraseña ingresado.
     * En caso de ser correcto, devuelve la cuenta con el token necesario para realizar las demás consultas.
     *
     * @param user -- user con userName y password
     * @return UserResponseDTO -- Objeto con userName y token
     * @throws UserNotFoundException -- se lanza la exception en caso de no encontrar al usuario
     */
    ApplicationUserResponseDTO login(ApplicationUserRequestDTO user );
}
