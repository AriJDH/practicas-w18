package meli.bootcamp.springvivo02.controller;

import meli.bootcamp.springvivo02.model.Empleado;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadoController
{
    @GetMapping("/empleado/{nombre}/{apellido}")
    public Empleado getEmpleado(@PathVariable String nombre, @PathVariable String apellido)
    {
        Empleado emp = new Empleado(nombre, apellido);
        return emp;
    }

    @GetMapping("/empleado")
    public Empleado findEmpleado(@RequestParam String nombre, @RequestParam String apellido)
    {
        Empleado e = new Empleado(nombre, apellido);
        return e;
    }

    @PostMapping("/empleado/crear")
    public Empleado createEmpleado(@RequestBody Empleado e)
    {
        return e;
    }
}
