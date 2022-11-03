package IntegradorVIVO;

import java.util.ArrayList;
import java.util.List;

public class Repositorio implements RepositorioBase{

    private int descuento;
    private List<String>  localizadores = new ArrayList<>();

    public Repositorio() {
    }

    @Override
    public int getDescuento() {
        return this.descuento;
    }


    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    @Override
    public List<String>getLocalizadores() {
        return this.localizadores;
    }

    @Override
    public void addLocalizador(String localizador) {
    }

    @Override
    public String toString() {
        return "Repositorio\n" +
                "descuento: " + descuento +
                "\nlocalizadores: ";
    }
}
