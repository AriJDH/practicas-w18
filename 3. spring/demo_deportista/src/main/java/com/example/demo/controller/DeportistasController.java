package com.example.demo.controller;

import com.example.demo.DTO.DTOResponse.DeporteDTONivelRes;
import com.example.demo.DTO.DTOResponse.DeporteDTORes;
import com.example.demo.DTO.DTOResponse.SportPersonsDTORes;
import com.example.demo.entity.Deporte;
import com.example.demo.entity.Persona;
import com.example.demo.entity.PersonaDeporte;
import com.example.demo.repository.DeporteCrud;
import com.example.demo.repository.PersonaCrud;
import com.example.demo.repository.PersonaDeporteCrud;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class DeportistasController {

    @GetMapping("/findSport")
    public List<Deporte> findSports(){
        DeporteCrud deporteCrud = new DeporteCrud();
        deporteCrud.loadData();
        DeporteDTORes deporteDTORes = new DeporteDTORes();
        deporteDTORes.setDeportes(deporteCrud.listar());
        deporteDTORes.setMessage("Todo OK por acá");
        deporteDTORes.setHttpStatus(HttpStatus.OK);

        return deporteDTORes.getDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTONivelRes> findSports(@PathVariable String name){
        DeporteCrud deporteCrud = new DeporteCrud();
        deporteCrud.loadData();
        DeporteDTONivelRes deporteDTORes = new DeporteDTONivelRes();

        List<Deporte> deportes = deporteCrud.buscar(name);

        if (deportes != null) {
            deporteDTORes.setMessage("Todo Ok por acá");
            deporteDTORes.setNivel(deportes.get(0).getNivel());
            deporteDTORes.setHttpStatus(HttpStatus.OK);
        }else{
            deporteDTORes.setMessage("Todo MAL por acá");
            deporteDTORes.setNivel(null);
            deporteDTORes.setHttpStatus(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(deporteDTORes,deporteDTORes.getHttpStatus());
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<SportPersonsDTORes> findSportsPersons(){
        DeporteCrud deporteCrud = new DeporteCrud();
        deporteCrud.loadData();

        PersonaCrud personaCrud = new PersonaCrud();
        personaCrud.loadData();

        Random r1 = new Random();

        PersonaDeporteCrud personaDeporteCrud = new PersonaDeporteCrud();
        List<Persona> personas = personaCrud.listar();
        List<Deporte> deportes = deporteCrud.listar();

        for (Persona p: personas) {
            PersonaDeporte persona1 = new PersonaDeporte();
            persona1.setPersona(p);
            int indice = r1.nextInt(4);
            List<Deporte> dep = new ArrayList<>();

            for (int i = 0; i < indice; i++ )  {
                dep.add(deportes.get(i));
                persona1.setDeporteList(dep);
            }
            personaDeporteCrud.guardar(persona1);
        }

        SportPersonsDTORes sportPersonsDTORes = new SportPersonsDTORes(
                personaDeporteCrud.listar(),
                "Todo Ok por acá",
                HttpStatus.OK
        );

        return new ResponseEntity<>(sportPersonsDTORes, sportPersonsDTORes.getHttpStatus());
    }
}
