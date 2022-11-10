package EjercicioPG2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CovidController {
    static ArrayList<Sintoma> sintomas = new ArrayList<>();
    static ArrayList<Persona> personas = new ArrayList<>();

    static{
        sintomas.add(new Sintoma(10021,"Fiebre",7));
        sintomas.add(new Sintoma(63031,"Tos",3));
        sintomas.add(new Sintoma(93182,"Flema",4));

        personas.add(new Persona(1,"Juan","Perez",17));
        personas.add(new Persona(2,"Roberto","Avila",65));
        personas.add(new Persona(3,"Hernan","Hoyos",70));

        personas.get(0).addSintoma(sintomas.get(1));
        personas.get(1).addSintoma(sintomas.get(0));
        personas.get(1).addSintoma(sintomas.get(2));

    }

    @GetMapping("/findSymptom")
    public  ArrayList<Sintoma> findSintomas(){
        return this.sintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> getSintoma(@PathVariable String name){
        Sintoma ans = this.sintomas.stream().filter(x -> x.getNombre().equals(name)).findAny().orElse(null);
        if(ans != null) return new ResponseEntity<>(ans,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findRiskPerson")
    public  List<PersonaDTO> getSintomas(){
        ArrayList<PersonaDTO> personasO = new ArrayList<>();
        for(Persona persona:personas){
            PersonaDTO temp = new PersonaDTO();
            temp.setNombreCompleto(persona.getNombre()+" "+persona.getApellido());
            temp.setEdad(persona.getEdad());
            temp.setSintomas(persona.getSintomas());
            personasO.add(temp);
        }

        List<PersonaDTO> ans = personasO.stream()
                                             .filter(x -> x.getEdad()>=60 &&
                                                          x.getSintomas().size() > 0).collect(Collectors.toList());

        return ans;
    }
}
