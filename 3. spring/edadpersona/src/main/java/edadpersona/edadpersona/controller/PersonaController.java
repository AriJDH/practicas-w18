package edadpersona.edadpersona.controller;


import edadpersona.edadpersona.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class PersonaController {

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public Persona getEdad(@PathVariable Integer dia,
                           @PathVariable Integer mes,
                           @PathVariable Integer anio){

        LocalDate fecha = LocalDate.of(anio,mes,dia);
        Period edad = Period.between(fecha,LocalDate.now());
        Persona persona = new Persona();
        persona.setEdad(String.valueOf(edad.getYears()));
        return persona;
    }
}
