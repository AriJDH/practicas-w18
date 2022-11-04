package clase3.AgenciaTurismo;

import java.util.ArrayList;

public class Repositorio {

    private ArrayList<Localizador> localizadores;


    public Repositorio() {
        localizadores = new ArrayList<Localizador>();
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public void eliminarLocalizador(Localizador localizador) {
        localizadores.remove(localizador);
    }


}
