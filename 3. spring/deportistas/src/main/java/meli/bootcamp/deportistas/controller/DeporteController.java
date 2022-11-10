package meli.bootcamp.deportistas.controller;

import meli.bootcamp.deportistas.DTO.response.DeporteDTORes;
import meli.bootcamp.deportistas.DTO.response.PersonaDTORes;
import meli.bootcamp.deportistas.entities.Deporte;
import meli.bootcamp.deportistas.repositories.GeneralRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DeporteController
{
    GeneralRepository gRepository = new GeneralRepository();
    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<DeporteDTORes>> getSports()
    {
        ArrayList<Deporte> listaDeportes = gRepository.getListaDeporte();
        ArrayList<DeporteDTORes> listaDTODeportes = new ArrayList<>();
        for (Deporte d :
                listaDeportes) {
            DeporteDTORes depDTO = new DeporteDTORes(d.getNombre(),d.getNivel());
            listaDTODeportes.add(depDTO);
        }
        return new ResponseEntity<ArrayList<DeporteDTORes>>(listaDTODeportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTORes> findSport(@PathVariable("name") String nombre)
    {
        Deporte d = gRepository.findDeporteByNombre(nombre);
        if (d != null)
        {
            DeporteDTORes depDTO = new DeporteDTORes(d.getNombre(),d.getNivel());
            return new ResponseEntity<>(depDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<ArrayList<PersonaDTORes>> findSportsPersons()
    {
        return null;
    }
}
