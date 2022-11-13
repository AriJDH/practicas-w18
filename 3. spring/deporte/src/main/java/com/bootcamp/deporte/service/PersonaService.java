package com.bootcamp.deporte.service;

import com.bootcamp.deporte.dto.req.PersonaReqDTO;
import com.bootcamp.deporte.dto.resp.PersonaResDTO;
import com.bootcamp.deporte.entity.Persona;
import com.bootcamp.deporte.persistence.BBDD;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonaService {
    private BBDD bbdd=new BBDD();

    public void crearPersona(PersonaReqDTO personaReqDTO){
        Persona persona=new Persona();
        persona.setNombre(personaReqDTO.getNombre());
        persona.setApellido(personaReqDTO.getApellido());
        persona.setEdad(personaReqDTO.getEdad());
        persona.setDeportes(personaReqDTO.getDeportes());
        bbdd.crearPersona(persona);
    }
    public List<PersonaResDTO> findSportsPersons(){
        Map<Integer,Persona>personas=bbdd.getPersonas();
        List<PersonaResDTO>personaResDTOS=new ArrayList<>();
        for (Persona persona : personas.values()) {
            PersonaResDTO dto=new PersonaResDTO();
            dto.setNombre(persona.getNombre());
            dto.setApellido(persona.getApellido());
            List<String>deportesNombre=new ArrayList<>();
            Optional.ofNullable(persona.getDeportes())
                    .ifPresentOrElse(depo -> depo.forEach(deporte -> deportesNombre.add(deporte.getNombre()))
                    ,()->new Exception("Vacio"));
            /*persona.getDeportes()
                    .forEach(deporte -> deportesNombre.add(deporte.getNombre()));*/
            dto.setNombreDeporte(deportesNombre);
            personaResDTOS.add(dto);
        }
        return personaResDTOS;
    }
}
