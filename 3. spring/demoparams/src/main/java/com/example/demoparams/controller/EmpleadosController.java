package com.example.demoparams.controller;

import com.example.demoparams.DTO.request.EmpleadoDTOReq;
import com.example.demoparams.DTO.response.EmpleadoDTORes;
import com.example.demoparams.entity.Empleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadosController {

    @GetMapping("/empleado/{nombre}/{apellido}")
    public Empleado getEmpleado(@PathVariable String nombre, @PathVariable String apellido){
        Empleado empleado = new Empleado(nombre, apellido);

        return empleado;
    }

    @GetMapping("/empleado")
    public Empleado findEmpleado(@RequestParam String nombre, @RequestParam (required = false)  String apellido){
        Empleado empleado = new Empleado(nombre, apellido);

        return empleado;
    }

    @PostMapping("/crear")
    public ResponseEntity<EmpleadoDTORes> createEmpleado(@RequestBody EmpleadoDTOReq empleado){
        EmpleadoDTORes empleadoDTORes = new EmpleadoDTORes(empleado.getNombre(), empleado.getApellido(), "El empleado fue creado correctamente.");

        return new ResponseEntity<EmpleadoDTORes>(empleadoDTORes, HttpStatus.CREATED);
    }

}
