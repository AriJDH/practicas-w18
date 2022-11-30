package covid19.demo.repository;

import covid19.demo.entity.Sintoma;

import java.util.ArrayList;

public class SintomasRepository {

    static ArrayList<Sintoma> sintomas = new ArrayList<>(){
        {
            add(new Sintoma(1,"Tos","bajo"));
            add(new Sintoma(2,"Fiebre","Alto"));
            add(new Sintoma(3,"Gripe","Medio"));
            add(new Sintoma(4,"Asfixia","Alto"));
        }
    };


    public static ArrayList<Sintoma> getSintomas(){
        return sintomas;
    }

}
