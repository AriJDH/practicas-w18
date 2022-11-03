package java_p2;

import java.util.HashMap;
import java.util.Map;

public class Carrera {

    final int CIRCUITO_CHICO = 2;
    final int CIRCUITO_MEDIO = 5;
    final int CIRCUITO_AVANZADO = 10;

    private Map<Integer,Persona> particCircuChico;
    private Map<Integer,Persona> particCircuMedio;
    private Map<Integer,Persona> particCircuAvanzado;

    public Carrera (){
        particCircuChico = new HashMap<>();
        particCircuMedio = new HashMap<>();
        particCircuAvanzado = new HashMap<>();
    }

    public void agregarParticipante(Map<Integer,Persona> listado, Persona pNueva){
        int clave = listado.size() + 1;
        listado.put(clave, pNueva);
    }
}
