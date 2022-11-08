import java.util.ArrayList;
import java.util.List;

public class SerieDoble extends Prototipo{

    List<Number> lista;

    public SerieDoble() {
        this.lista = new ArrayList<>();
    }

    public List<Number> getLista() {
        return lista;
    }

    public void setLista(List<Number> lista) {
        this.lista = lista;
    }

    @Override
    public Double siguienteValor(Number valor) {
        return valor.doubleValue()+2;
    }

    @Override
    public void reiniciarSerie() {
        lista.clear();
    }

    @Override
    public List<Number> valorInicial(Number valor) {
        lista.add(valor);
        return lista;
    }
}
