package ejercicios.ejerciciodeportistas.controlador;

import ejercicios.ejerciciodeportistas.DTO.response.DeportDTOResponse;
import ejercicios.ejerciciodeportistas.DTO.response.PersonaDTOResponse;
import ejercicios.ejerciciodeportistas.entidades.Deporte;
import ejercicios.ejerciciodeportistas.modelo.Modelo;
import ejercicios.ejerciciodeportistas.repositorio.Repositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ControladorDeportistas {



    public ControladorDeportistas() {
        modelo = new Modelo();
    }
    Modelo modelo;
    @GetMapping( "/findSport")
    public ResponseEntity<ArrayList<DeportDTOResponse>> findSports(){


        ArrayList<DeportDTOResponse> respuesta = modelo.findSports();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);

    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<DeportDTOResponse> findSportByName(@PathVariable String nombre){


        DeportDTOResponse respuesta = modelo.findSportByName(nombre);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);

    }
    @GetMapping( "/findSportsPerson")
    public ResponseEntity<ArrayList<PersonaDTOResponse>> findPerson(){


        ArrayList<PersonaDTOResponse> respuesta = modelo.findPerson();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);

    }


}
