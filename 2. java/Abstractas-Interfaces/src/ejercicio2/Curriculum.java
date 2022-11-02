package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Documento{
    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona) {
        this.persona=persona;
        habilidades= new ArrayList<>();
    }
    public String imprimirContenido(){
        return persona.toString()+", Habilidades= "+getHabilidades();
    }

    public String getHabilidades(){
        String aRetornar="";
        for(String h: habilidades){
            aRetornar=""+h+", ";
        }
        return aRetornar;
    }
}
