package EjIntegradorVivo.Repositorio;
import EjIntegradorVivo.Clases.Cliente;
import EjIntegradorVivo.Clases.Localizador;
import EjIntegradorVivo.IClienteRepositorio.IRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositorioLocalizador implements IRepositorio<Localizador> {
    private final List <Localizador> listaLocalizadores;
    private static final AtomicInteger count = new AtomicInteger(0);

    public RepositorioLocalizador() {
        this.listaLocalizadores = new ArrayList<>();
    }

    @Override
    public Long create(Localizador localizador) {
        localizador.setId(count.incrementAndGet());
        listaLocalizadores.add(localizador);
        localizador.printLocalizador();
        return count.longValue();
    }

    @Override
    public Localizador findOne(long id) {
        for(Localizador localizador: this.listaLocalizadores){
            if(localizador.getClienteId() == id){
                return localizador;
            }
        }
        return null;
    }

    @Override
    public List<Localizador> findAll() {
        return this.listaLocalizadores;
    }

    @Override
    public void delete(long id) {
        for(int i=0; i<this.listaLocalizadores.size(); i++){
            if(listaLocalizadores.get(i).getClienteId() == id){
                listaLocalizadores.remove(i);
            }
        }
    }

    @Override
    public Localizador update(Localizador localizador) {
        for(Localizador loc: this.listaLocalizadores){
            if(loc.getId() == localizador.getId()){
                loc = localizador;
                return loc;
            }
        }
        return null;
    }

}
