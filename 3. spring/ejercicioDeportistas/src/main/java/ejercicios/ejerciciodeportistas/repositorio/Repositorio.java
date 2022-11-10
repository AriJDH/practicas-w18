package ejercicios.ejerciciodeportistas.repositorio;

import ejercicios.ejerciciodeportistas.DTO.response.DeportDTOResponse;
import ejercicios.ejerciciodeportistas.entidades.Deporte;
import ejercicios.ejerciciodeportistas.entidades.Persona;

import java.util.ArrayList;

public class Repositorio {


    ArrayList<Persona> listaPersonas = new ArrayList <>();
    ArrayList<Deporte> listaDeportes = new ArrayList <>();

    public Repositorio() {
        inicializarListaPersonas();
        inicializarDeportes();
    }

    public void inicializarListaPersonas(){

        listaPersonas.add(new Persona("Juan","Perez",32,"Atletismo"));
        listaPersonas.add(new Persona("Carlos","Restrepo",26,"Futbol"));
        listaPersonas.add(new Persona("Laura","Lopez",18,"Futbol"));
        listaPersonas.add(new Persona("Juan","Perez",29,"Atletismo"));

    }

    public void inicializarDeportes(){
        listaDeportes.add(new Deporte("Futbol","Amateur"));
        listaDeportes.add(new Deporte("Futbol","Profesional"));
        listaDeportes.add(new Deporte("Atletismo","Relevos"));

    }

    public ArrayList<Deporte> findSports(){
        return listaDeportes;
    }
    public Deporte findSportByName(String nombre){
        for (Deporte deporte:listaDeportes) {
            if (deporte.getNombre().equals(nombre)) {
                return deporte;
            }
        }
        return null;
    }

    public ArrayList<Persona> findPerson(){
        return listaPersonas;
    }

}
