package com.example.edad.controller;

public class controller {

    @RestController
    public class EdadPersonaController {
        @GetMapping(path = "/edadPersona/{dia}/{mes}/{anio}/")
        public String edadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

            Period edad = Period.between(fechaNacimiento, fechaActual);
            return String.valueOf(edad.getYears());
        }
    }
}
