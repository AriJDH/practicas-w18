package Turismo.Repository;

import Turismo.Clases.Localizador;
import Turismo.Interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador implements IRepository<Localizador> {
    List<Localizador> listaLocalizador = new ArrayList<>();

    @Override
    public Localizador create(Localizador localizador) {
        listaLocalizador.add(new Localizador());
        return localizador;
    }

    @Override
    public void delete(Localizador localizador) {

    }

    @Override
    public Localizador find(Localizador localizador) {
        return null;
    }

    @Override
    public Localizador update(Localizador anterior, Localizador nuevo) {
        return null;
    }

    @Override
    public Iterable<Localizador> findAll() {
        return null;
    }
}
