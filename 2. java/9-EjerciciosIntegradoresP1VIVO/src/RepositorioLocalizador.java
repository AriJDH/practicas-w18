import java.util.List;

public class RepositorioLocalizador implements IRepositorio<Localizador> {

    // Atributos
    private List<Localizador> localizadores;

    @Override
    public void agregar(Localizador localizador) {
        localizadores.add(localizador);
    }

    @Override
    public List<Localizador> buscarTodos() {
        return localizadores;
    }

    @Override
    public Localizador buscarId(Long id) {
        Localizador localizadorEncontrado = null;
        for (Localizador localizador : localizadores
        ) {
            if (localizador.getId().equals(id)) {
                localizadorEncontrado = localizador;
            }
        }
        return localizadorEncontrado;
    }

    @Override
    public void eliminar(Long id) {
        Localizador localizadorEncontrado = this.buscarId(id);
        this.localizadores.remove(localizadorEncontrado);

    }
}
