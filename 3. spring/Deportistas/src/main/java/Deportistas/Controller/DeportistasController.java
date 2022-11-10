package Deportistas.Controller;

import Deportistas.DTO.DeporteAllDTORes;
import Deportistas.DTO.DeporteDTORes;
import Deportistas.DTO.PersonaDTORes;
import Deportistas.Entity.Deporte;
import Deportistas.Entity.Persona;
import Deportistas.Repository.DeporteRepository;
import Deportistas.Repository.PersonaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DeportistasController {

    private static  DeporteRepository deporteRepository = new DeporteRepository(); // para guardar los deportes
    private static  PersonaRepository personaRepository = new PersonaRepository(); // para guardar las personas

    // cargo data
    static {
        Deporte futbol = new Deporte("Futbol","amateur");
        Deporte boxeo = new Deporte("Boxeo","semi-profesional");
        Deporte natacion = new Deporte("Natación","profesional");
        Deporte danza = new Deporte("Danza","profesional");
        deporteRepository.agregar(futbol);
        deporteRepository.agregar(boxeo);
        deporteRepository.agregar(natacion);
        deporteRepository.agregar(danza);
        personaRepository.agregar(new Persona("Marcos", "Etche", 25, Arrays.asList(boxeo, futbol)));
        personaRepository.agregar(new Persona("Sofia", "Monte", 29, Arrays.asList(natacion, danza)));
        personaRepository.agregar(new Persona("Seba", "Gines", 35, Arrays.asList(futbol)));
    }


    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteAllDTORes>> findSports(){
        List<DeporteAllDTORes> deporteAllDTOResList = new ArrayList<>();
        for( Deporte deporte : deporteRepository.listarTodos()){
            deporteAllDTOResList.add(new DeporteAllDTORes(deporte.getNombre(), deporte.getNivel(), "OK"));
        }
        return new ResponseEntity<>(deporteAllDTOResList, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity findSport(@PathVariable String name){
        Optional<Deporte> deporte = deporteRepository.listarTodos().stream().filter(x-> x.getNombre().equals(name)).findFirst();
        if (deporte.isPresent()){
            DeporteDTORes dtoRes = new DeporteDTORes(deporte.get().getNivel(), "Deporte encontrado OK");
            return new ResponseEntity<>(dtoRes, HttpStatus.OK);
        }
        return new ResponseEntity<>(new DeporteDTORes(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTORes>> findSportsPersons(){
        List<PersonaDTORes> personaDTOResList = new ArrayList<>();

        for ( Persona persona : personaRepository.listarTodos()){
            personaDTOResList.add(new PersonaDTORes(persona.getNombre(), persona.getApellido(),
                    persona.getDeporteList().stream().map(x->x.getNombre()).collect(Collectors.toList())
                    ,"OK"));
        }
        return new ResponseEntity<>(personaDTOResList, HttpStatus.OK);
    }
}