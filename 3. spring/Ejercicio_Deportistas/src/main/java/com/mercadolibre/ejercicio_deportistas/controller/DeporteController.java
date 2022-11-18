package com.mercadolibre.ejercicio_deportistas.controller;

import com.mercadolibre.ejercicio_deportistas.DTO.DeportesDTO;
import com.mercadolibre.ejercicio_deportistas.DTO.ListaDeportesDTO;
import com.mercadolibre.ejercicio_deportistas.DTO.ListaPersonasConDeporteDTO;
import com.mercadolibre.ejercicio_deportistas.entity.Deporte;
import com.mercadolibre.ejercicio_deportistas.entity.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {

    private ListaDeportesDTO listaDeportes = new ListaDeportesDTO();
    private ListaPersonasConDeporteDTO listaPersonasConDeporte = new ListaPersonasConDeporteDTO();

    public void agregarPersonaALista(Persona persona){
        this.listaPersonasConDeporte.getDeportista().add(persona.getNombre());
    }

    public void agregarDeporteAPersona(String deporte, String nombre){
        for(DeportesDTO deportes : this.listaDeportes.getDeportes()){
            if(deportes.getNombre().equals(deporte)) {
                String nombreNuevoDeporte = deportes.getNombre();
                String nivelNuevoDeporte = deportes.getNivel();
                Deporte deporteAux = new Deporte(nombreNuevoDeporte, nivelNuevoDeporte);
                for (String persona : listaPersonasConDeporte.getDeportista()){
                    if (persona.equals(nombre)){
                        
                        persona.getDeportes().add(deporteAux);
                    }
                }

            }



    }


    @PostMapping ("/addDeporte/{nombre}/{nivel}")
    public void addDeporte(@PathVariable String nombre, @PathVariable String nivel){
        Deporte deporte1 = new Deporte(nombre, nivel);
        DeportesDTO deporteDTO = new DeportesDTO(nombre, nivel);
        listaDeportes.agregarDeporte(deporteDTO);
        System.out.println("El deporte agregado es: " + deporte1.getNombre() + " y el nivel es: "+
                deporte1.getNivel());
        System.out.println("Lista de deportes: " + listaDeportes.getDeportes());
    }

    @PostMapping ("/addPersona/{nombre}/{apellido}/{edad}")
    public void addPersona(@PathVariable String nombre, @PathVariable String apellido, @PathVariable String edad){
        Persona persona = new Persona(nombre, apellido, edad);
        this.agregarPersonaALista(persona);
    }

    @PostMapping("/findSportsPersons")
    public EntityResponse<ArrayList<String>> findSportsPersona(){
        ArrayList<String> resultado = new ArrayList<>();


    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeportesDTO>> listarDeportes(){
        System.out.println(this.listaDeportes.getDeportes());
        return new ResponseEntity<>(this.listaDeportes.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeportesDTO> getDeporte(@PathVariable String name){
        DeportesDTO deporteReturn = new DeportesDTO();
        for(DeportesDTO deportes : this.listaDeportes.getDeportes()){
            if(deportes.getNombre().equals(name)){
                deporteReturn=deportes;
            }
        }
        return new ResponseEntity<>(deporteReturn, HttpStatus.OK);
    }

    @GetMapping("/vincular/{persona}/{deporte}")
    public void vincular(@PathVariable String persona, @PathVariable Deporte deporte){

    }

}
