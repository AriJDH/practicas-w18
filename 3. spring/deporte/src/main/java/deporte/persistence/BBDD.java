package deporte.persistence;

import com.personadeporte.PersonaDeporte.entity.Deporte;
import com.personadeporte.PersonaDeporte.entity.Persona;

import java.util.HashMap;
import java.util.Map;

public class BBDD {

    Map<Integer, Persona> personas = new HashMap<>();
    Map<Integer, Deporte> deportes = new HashMap<>();

    public BBDD() {
    }

    public void crearDeporte(Deporte deporte){
        deportes.put(deporte.getId(), deporte);

    }

    public void crearPersona(Persona persona){
        personas.put(persona.getId(),persona);
    }

    public Map<Integer, Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Map<Integer, Persona> personas) {
        this.personas = personas;
    }

    public Map<Integer, Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(Map<Integer, Deporte> deportes) {
        this.deportes = deportes;
    }
}