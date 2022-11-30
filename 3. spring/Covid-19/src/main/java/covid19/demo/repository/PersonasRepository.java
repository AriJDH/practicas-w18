package covid19.demo.repository;

import covid19.demo.entity.Persona;
import covid19.demo.entity.Sintoma;

import java.util.ArrayList;

public class PersonasRepository {

    static ArrayList<Persona> personas = new ArrayList<>(){
        {
            add(new Persona(1,"Juan","Lopez",78,new ArrayList<>(){{ add(2);add(3); }}));
            add(new Persona(2,"Andres","Torres",62,new ArrayList<>(){{ add(1);add(4); }}));
            add(new Persona(3,"Felipe","Mesa",54,new ArrayList<>(){{ add(3);add(4); }}));
            add(new Persona(4,"Carlos","Ochoa",23,new ArrayList<>(){{ add(1);add(3); }}));
            add(new Persona(5,"Jose","Velez",61,new ArrayList<>(){{ add(2);add(3); }}));
        }
    };


    public static ArrayList<Persona> getPersonas(){
        return personas;
    }

}
