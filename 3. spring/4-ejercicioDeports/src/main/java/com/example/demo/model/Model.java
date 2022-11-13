package com.example.demo.model;

import com.example.demo.DTO.request.DeporteDTOReq;
import com.example.demo.DTO.response.DeporteDTORes;
import com.example.demo.DTO.response.PeopleDTORes;
import com.example.demo.entity.Deporte;
import com.example.demo.entity.People;
import com.example.demo.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter

public class Model {
    private Repository repository;

    public Model() {
        repository = new Repository();
    }

    //metodos que busca en el repositorio y trae los valores correspondientes

    /*
     *
     * Ver todos los deportes que tenemos cargados
     * PATH: /findSports
     */

    public List<DeporteDTORes> findSports() {
        List<Deporte> listDeports = repository.findSports();
        List<DeporteDTORes> deportsRequest = new ArrayList<>();

        for (Deporte deporte : listDeports) {
            deportsRequest.add(new DeporteDTORes(deporte.getName(), deporte.getLevel()));
        }
        return deportsRequest;
    }

    /*
     * Consultar si existe un deporte ingresando su nombre.
     * De existir, se deberá mostrar el nivel del mismo.
     * Utilizar la clase ResponseEntity para devolver la respuesta.
     * PATH: /findSport/{name}
     */

    public DeporteDTORes findSport(String name) {
        Deporte deporte = repository.findSportByName(name);

        return new DeporteDTORes(deporte.getName(), deporte.getLevel());
    }

    /*
     * Visualizar a las personas deportistas.
     * Queremos que se vea un listado con el nombre y el apellido de la persona y
     * el nombre del deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado).
     * Para este punto es importante valerse de un DTO. PATH: /findSportsPersons
     */

    public List<PeopleDTORes> findSportsPersons() {
        List<People> peopleList = repository.findPeople();
        List<PeopleDTORes> peopleRequest = new ArrayList<>();

        for (People people : peopleList) {
            peopleRequest.add(new PeopleDTORes(people.getName(), people.getLastname(), people.getListDeports()));
        }
        return peopleRequest;
    }
}
