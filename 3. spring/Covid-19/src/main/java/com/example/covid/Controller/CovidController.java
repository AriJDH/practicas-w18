package com.example.covid.Controller;

import com.example.covid.Dto.PersonaDTO;
import com.example.covid.Dto.SintomaDTO;
import com.example.covid.Dto.SintomaNivelDTO;
import com.example.covid.Entity.Persona;
import com.example.covid.Entity.Sintoma;
import com.example.covid.Repository.RepositoryPersonaImp;
import com.example.covid.Repository.RepositorySintomaImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CovidController {
    private static RepositorySintomaImp sintomaRepository = new RepositorySintomaImp(); // para guardar los síntomas
    private static RepositoryPersonaImp personaRepository = new RepositoryPersonaImp(); // para guardar las personas

    // cargo data
    static {
        Sintoma fiebre = new Sintoma("1","fiebre","alto");
        Sintoma tos = new Sintoma("2","tos","bajo");
        Sintoma dolorCabeza = new Sintoma("3","dolorCabeza","medio");
        Sintoma mareos = new Sintoma("4","mareos","medio");
        sintomaRepository.agregar(fiebre);
        sintomaRepository.agregar(tos);
        sintomaRepository.agregar(dolorCabeza);
        sintomaRepository.agregar(mareos);
        personaRepository.agregar(new Persona(1L,"Marcos", "Etche", 25, Arrays.asList(fiebre)));
        personaRepository.agregar(new Persona(2L,"Sofia", "Monte", 29, Arrays.asList(fiebre)));
        personaRepository.agregar(new Persona(3L,"Seba", "Gines", 65, Arrays.asList(dolorCabeza)));
        personaRepository.agregar(new Persona(4L,"Facundo", "Parra", 70, Arrays.asList(fiebre, tos)));
        personaRepository.agregar(new Persona(5L,"Abel", "Masuero", 62, Arrays.asList(fiebre, tos)));
        personaRepository.agregar(new Persona(6L,"Matias", "Pisano", 63, Arrays.asList()));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> findSymptom(){
        List<SintomaDTO> simtomaDTOResList = new ArrayList<>();
        for( Sintoma sintoma : sintomaRepository.listarTodos()){
            simtomaDTOResList.add(new SintomaDTO(sintoma.getCodigo(),sintoma.getNombre(), sintoma.getNivel_de_gravedad(), "OK"));
        }
        return new ResponseEntity<>(simtomaDTOResList, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity findSymptom(@PathVariable String name){
        Optional<Sintoma> sintoma = sintomaRepository.listarTodos().stream().filter(x-> x.getNombre().equals(name)).findFirst();
        if (sintoma.isPresent()){
            SintomaNivelDTO dtoRes = new SintomaNivelDTO(sintoma.get().getNivel_de_gravedad(), "Sintoma encontrado OK");
            return new ResponseEntity<>(dtoRes, HttpStatus.OK);
        }
        return new ResponseEntity<>(new SintomaNivelDTO(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findRiskPerson(){
        List<PersonaDTO> personaDTOResList = new ArrayList<>();

        for ( Persona persona : personaRepository.listarTodos()){
            if(persona.getEdad() > 60 && !persona.getSintomaList().isEmpty()){
                personaDTOResList.add(new PersonaDTO(persona.getNombre(), persona.getApellido(),"OK"));
            }
        }
        /*
        personaRepository.listarTodos()
                .stream()
                .filter(x->x.getEdad() > 60)
                .filter(x->!x.getSintomaList().isEmpty());

         */
        return new ResponseEntity<>(personaDTOResList, HttpStatus.OK);
    }
}
