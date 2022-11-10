package Deportistas.Repository;

import Deportistas.Entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository implements IRepository<Persona>{

    private List<Persona> personaList;

    public PersonaRepository() {
        this.personaList = new ArrayList<>();
    }

    @Override
    public List<Persona> listarTodos() {
        return personaList;
    }

    @Override
    public void agregar(Persona persona) {
        personaList.add(persona);
    }
}
