package com.mercadolibre.pf_be_java_hisp_w18_g1.service;


import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ApplicationUserRequestDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ApplicationUserResponseDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.UserNotFoundException;

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
