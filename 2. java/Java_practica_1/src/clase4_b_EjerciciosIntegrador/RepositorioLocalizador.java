package clase4_b_EjerciciosIntegrador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RepositorioLocalizador implements IRepositorio<Localizador>{
    private Set<Localizador> localizadorList;

    @Override
    public void agregar(Localizador localizador) {
        localizadorList.add(localizador);
    }

    @Override
    public Set<Localizador> traerTodos() {
        return localizadorList;
    }

    public RepositorioLocalizador() {
        this.localizadorList = new HashSet<>();
    }
}
