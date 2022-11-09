package clase4_b_EjerciciosIntegrador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador implements IRepositorio<Localizador>{
    private List<Localizador> localizadorList;

    @Override
    public void agregar(Localizador localizador) {
        localizadorList.add(localizador);
    }

    @Override
    public List<Localizador> listarTodos() {
        return localizadorList;
    }

    public RepositorioLocalizador() {
        this.localizadorList = new ArrayList<>();
    }
}
