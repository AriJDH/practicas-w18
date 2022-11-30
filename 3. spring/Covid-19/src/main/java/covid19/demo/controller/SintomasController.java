package covid19.demo.controller;


import covid19.demo.dto.PersonaDTO;
import covid19.demo.dto.SintomaDTO;
import covid19.demo.dto.SintomaGravedadDTO;
import covid19.demo.entity.Persona;
import covid19.demo.entity.Sintoma;
import covid19.demo.repository.PersonasRepository;
import covid19.demo.repository.SintomasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SintomasController {

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getSintomas(){

        ArrayList<SintomaDTO> sintomasDTO = (ArrayList<SintomaDTO>) SintomasRepository.getSintomas()
                .stream()
                .map(sintoma -> new SintomaDTO(sintoma.getCodigo(),sintoma.getNombre(), sintoma.getNivel_de_gravedad()))
                .collect(Collectors.toList());
        return new ResponseEntity<List< SintomaDTO>>(sintomasDTO,HttpStatus.OK);

    }


    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaGravedadDTO> BuscarSintoma(@PathVariable String name){
        Sintoma sintomaEncontrado =  SintomasRepository.getSintomas().stream().filter(sintoma -> name.equals(sintoma.getNombre())).findFirst().orElse(null);
        SintomaGravedadDTO sintomaDTO = new SintomaGravedadDTO(sintomaEncontrado.getNivel_de_gravedad());


        return new ResponseEntity<>(sintomaDTO,HttpStatus.OK);

    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> riesgoPersona(){
        ArrayList<Persona> personasFind = (ArrayList<Persona>) PersonasRepository.getPersonas().stream()
                .filter(persona -> persona.getEdad() > 60 && persona.getSintomasId().size() > 0)
                .collect(Collectors.toList());
        ArrayList<PersonaDTO> personasDTO = (ArrayList<PersonaDTO>) personasFind.stream()
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido()))
                .collect(Collectors.toList());

        return new ResponseEntity<List<PersonaDTO>>(personasDTO,HttpStatus.OK);

    }

}
