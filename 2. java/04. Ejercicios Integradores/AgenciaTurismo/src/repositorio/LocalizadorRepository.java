package repositorio;

import modelo.Cliente;
import modelo.Localizador;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LocalizadorRepository implements ILocalizadorRepository{
    private Set<Localizador> localizadores = new HashSet<>();

    @Override
    public void add(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    @Override
    public Set<Localizador> getAll() {
        return this.localizadores;
    }

    @Override
    public Localizador getOne(Long id) {
        return this.localizadores.stream().filter(l->l.getId().equals(id)).findFirst().orElseThrow(()->new RuntimeException("No existe Localizador"));
    }

    @Override
    public Set<Localizador> getByCliente(Cliente cliente) {
        return this.localizadores.stream().filter(l->l.getCliente().equals(cliente)).collect(Collectors.toSet());
    }
}
