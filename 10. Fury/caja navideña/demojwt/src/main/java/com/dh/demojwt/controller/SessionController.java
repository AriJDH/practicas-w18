package com.dh.demojwt.controller;

import com.dh.demojwt.dto.response.UserResponseDTO;
import com.dh.demojwt.dto.request.UserRequestDTO;
import com.dh.demojwt.service.ISessionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class SessionController {
    private final ISessionService service;

    public SessionController(ISessionService sessionService) {
        this.service = sessionService;
    }

    /**
     * Realiza la validación del usuario y contraseña ingresado.
     * En caso de ser correcto, devuelve la cuenta con el token necesario para realizar las demás consultas.
     *
     * @param user - user con userName y password
     * @return UserResponseDTO
     */
    @PostMapping("/sign-in")
    public UserResponseDTO login( @RequestBody UserRequestDTO user ) {
        return service.login(user);
    }

}