package com.personadeporte.PersonaDeporte.service;

import com.personadeporte.PersonaDeporte.dto.req.PersonaReqDTO;
import com.personadeporte.PersonaDeporte.dto.res.PersonaResDTO;
import com.personadeporte.PersonaDeporte.entity.Persona;
import com.personadeporte.PersonaDeporte.persistence.BBDD;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonaService {
    private BBDD bbdd = new BBDD();

    public void crearPersona(PersonaReqDTO personaReqDTO){
        Persona persona = new Persona(personaReqDTO.getNombre()
                ,personaReqDTO.getApellido()
                ,personaReqDTO.getEdad()
                ,personaReqDTO.getDeportes());

        bbdd.crearPersona(persona);
    }

    public List<PersonaResDTO> findSportsPersons(){
        Map<Integer,Persona> personas = bbdd.getPersonas();
        List<PersonaResDTO> personaResDTOS = new ArrayList<>();
        for (Persona persona : personas.values()) {
            PersonaResDTO dto = new PersonaResDTO();
            dto.setNombre(persona.getNombre());
            dto.setApellido(persona.getApellido());
            List<String> deportesNombre = new ArrayList<>();
            persona.getDeportes().forEach(deporte -> deportesNombre.add(deporte.getNombre()));
            dto.setNombreDeporte(deportesNombre);
            personaResDTOS.add(dto);
        }

        return personaResDTOS;
    }

}
