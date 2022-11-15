package com.deportes.demo.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.deportes.demo.DTO.PersonaDeportistaDTO;
import com.deportes.demo.entity.Deporte;
import com.deportes.demo.entity.Persona;

@Repository
public class RepoDeDatos {

    List<Persona> personas = new ArrayList<>();
    List<Deporte> deportes = new ArrayList<>();
    List<PersonaDeportistaDTO> personasDeportistas = new ArrayList<>();

    public List<Persona> getPersonas() {
        personas.add(new Persona("Jose", "Sandona", 27));
        personas.add(new Persona("Manuel", "Perez", 30));
        personas.add(new Persona("Duki", "SSJ", 25));
        personas.add(new Persona("Khea", "HitBoy", 27));

        return personas;
    }

    public List<Deporte> getDeportes() {
        deportes.add(new Deporte("Futbol", "Dificil"));
        deportes.add(new Deporte("Golf", "Medio"));
        deportes.add(new Deporte("Natacion", "Facil"));
        deportes.add(new Deporte("Basquer", "Dificil"));

        return deportes;
    }

    public List<PersonaDeportistaDTO> getDTO() {

        personasDeportistas.add(new PersonaDeportistaDTO("Jose", "Sandona", "Futbol"));
        personasDeportistas.add(new PersonaDeportistaDTO("Manuel", "Pepe", "Basque"));
        personasDeportistas.add(new PersonaDeportistaDTO("Duki", "Rey", "Natacion"));
        personasDeportistas.add(new PersonaDeportistaDTO("Khea", "Pop", "Golf"));

        return personasDeportistas;
    }

}
