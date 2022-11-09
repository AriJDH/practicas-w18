package meli.bootcamp.springvivo01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController
{

    @GetMapping("/{nombre}")
    public String hola(@PathVariable("nombre") String nombre)
    {
        return "HOLA " + nombre;
    }

}
