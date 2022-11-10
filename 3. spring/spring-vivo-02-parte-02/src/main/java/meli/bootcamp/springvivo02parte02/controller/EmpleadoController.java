package meli.bootcamp.springvivo02parte02.controller;

import meli.bootcamp.springvivo02parte02.DTO.request.EmpleadoDTOReq;
import meli.bootcamp.springvivo02parte02.DTO.response.EmpleadoDTORes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {
    @PostMapping("/crear")
    public ResponseEntity<EmpleadoDTORes> createEmpleado(@RequestBody EmpleadoDTOReq e)
    {
        EmpleadoDTORes empleadoDTORes = new EmpleadoDTORes(e.getNombre(),e.getApellido(),"El empleado ha sido creado");
        return new ResponseEntity<>(empleadoDTORes, HttpStatus.CREATED);
    }
}
