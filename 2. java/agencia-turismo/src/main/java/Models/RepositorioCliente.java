package Models;

import Models.Localizador;

import java.util.Arrays;
import java.util.List;

public class RepositorioCliente {
    private List<Localizador> localizadores;

    public void addLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public void addLocalizador(Localizador ...localizador) {
        localizadores.addAll(Arrays.asList(localizador));
    }

    public void calcularDescuentos(){

    }


}
