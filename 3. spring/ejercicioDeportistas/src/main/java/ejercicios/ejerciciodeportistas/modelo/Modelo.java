package ejercicios.ejerciciodeportistas.modelo;

import ejercicios.ejerciciodeportistas.DTO.response.DeportDTOResponse;
import ejercicios.ejerciciodeportistas.DTO.response.PersonaDTOResponse;
import ejercicios.ejerciciodeportistas.entidades.Deporte;
import ejercicios.ejerciciodeportistas.entidades.Persona;
import ejercicios.ejerciciodeportistas.repositorio.Repositorio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter

public class Modelo {

    private Repositorio repo ;

    public Modelo() {
        repo=new Repositorio();
    }

    public ArrayList<DeportDTOResponse> findSports(){
        ArrayList<Deporte> listaDeportes = repo.findSports();
        ArrayList<DeportDTOResponse> respuesta = new ArrayList<>();

        for (Deporte deporte:listaDeportes) {

            respuesta.add(new DeportDTOResponse(deporte.getNombre()));

        }
        return respuesta;

    }
    public DeportDTOResponse findSportByName(String nombre){
        Deporte deporte = repo.findSportByName(nombre);
        DeportDTOResponse deporteRespuesta = null;
        if (deporte!=null){
            deporteRespuesta=new DeportDTOResponse(deporte.getNombre());
        }
        return deporteRespuesta;
    }
    public ArrayList<PersonaDTOResponse> findPerson(){
        ArrayList<Persona> listaPersona = repo.findPerson();
        ArrayList<PersonaDTOResponse> respuesta = new ArrayList<>();

        for (Persona persona:listaPersona) {

            respuesta.add(new PersonaDTOResponse(persona.getNombre(),persona.getApellido(), persona.getDeporte()));

        }
        return respuesta;

    }


}
