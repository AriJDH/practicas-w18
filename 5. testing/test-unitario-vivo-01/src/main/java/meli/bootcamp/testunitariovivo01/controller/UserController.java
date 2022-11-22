package meli.bootcamp.testunitariovivo01.controller;

import meli.bootcamp.testunitariovivo01.dto.UserDto;
import meli.bootcamp.testunitariovivo01.service.IUserService;
import meli.bootcamp.testunitariovivo01.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController
{

    IUserService userService;

    public UserController (UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.crearUsuario(userDto), HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> obtenerTodos()
    {
        return new ResponseEntity<>(userService.obtenerTodos(), HttpStatus.OK);
    }
}
