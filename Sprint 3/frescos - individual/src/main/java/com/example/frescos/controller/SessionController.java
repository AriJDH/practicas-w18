package com.example.frescos.controller;

import com.example.frescos.dtos.ApplicationUserRequestDTO;
import com.example.frescos.dtos.ApplicationUserResponseDTO;
import com.example.frescos.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @Autowired
    private SessionService service;

    /**
     * Realiza la validación del usuario y contraseña ingresado.
     * En caso de ser correcto, devuelve la cuenta con el token necesario para realizar las demás consultas.
     *
     * @param user - user con userName y password
     * @return UserResponseDTO
     */
    @PostMapping("/login")
    public ApplicationUserResponseDTO login(@RequestBody ApplicationUserRequestDTO user ) {
        return service.login(user);
    }

}