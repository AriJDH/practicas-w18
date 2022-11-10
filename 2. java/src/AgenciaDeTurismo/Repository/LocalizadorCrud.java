package AgenciaDeTurismo.Repository;

import AgenciaDeTurismo.Clases.Cliente;
import AgenciaDeTurismo.Clases.Localizador;
import AgenciaDeTurismo.Interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocalizadorCrud implements CrudRepository<Localizador> {
    private List<Localizador> listaLocalizador = new ArrayList<>();

    public List<Localizador> buscarCliente(Cliente cliente){
        if (listaLocalizador.stream().map(cli -> cli.getCliente().equals(cliente)).count() > 0){
            return listaLocalizador.stream().filter(cli -> cli.getCliente().equals(cliente)).collect(Collectors.toList());
        }else{
            List<Localizador> list = new ArrayList<>();
            return list;
        }
    }

    @Override
    public void save(Localizador objeto) {
        this.listaLocalizador.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (AgenciaDeTurismo.Clases.Localizador l : listaLocalizador) {
            System.out.println("Cliente: " + (l.getCliente().toString()));
            System.out.println("Reserva: " + (l.getReservas().toString()));
            System.out.println("Costo Total: " + l.getTotal());
        }
    }

    @Override
    public Optional<Localizador> buscar(Long localizadorBuscado) {
        boolean bandera = false;
        for (AgenciaDeTurismo.Clases.Localizador l : listaLocalizador) {
            if (l.getCodigoLocalizador() == localizadorBuscado) {
                System.out.println("----Localizador encontrada, sus datos son: ----");
                System.out.println(l.toString());
                return Optional.of(l);
            }
        }

        if (!bandera) {
            System.out.println("Cliente no encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        Optional<AgenciaDeTurismo.Clases.Localizador> rse = this.buscar(id);

        if (rse.isEmpty()) {
            System.out.println("No se encontró el localizador a borrar");
        }
        else {
            System.out.println("reserva borrado correctamente");
            listaLocalizador.remove(rse.get());
        }
    }

    @Override
    public List<Localizador> traerTodos() {
        return listaLocalizador;
    }
}
