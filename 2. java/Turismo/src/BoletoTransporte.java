import java.util.*;

public class BoletoTransporte implements RepositorioBase{
    protected RepositorioBase repositorio;
    protected int descuento = 0;
    public BoletoTransporte(RepositorioBase repositorio) {
        this.repositorio = repositorio;
        this.repositorio.addLocalizador("Boleto transporte");
        this.repositorio.setDescuento(this.getDescuento());
    }
    @Override
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    @Override
    public int getDescuento() {
        List<String> lista = this.repositorio.getLocalizadores();
        int descuento = 0;
        int HotelC = Collections.frequency(lista, "Hotel");
        int transC = Collections.frequency(lista, "BoletoTransporte");
        int viajeC = Collections.frequency(lista, "BoletoViaje");
        int comidaC = Collections.frequency(lista, "Comida");

        if(lista.size()>=2){
            descuento += 5;
        }else if((HotelC > 0) && (transC > 0) && (viajeC > 0) && (comidaC > 0)){
            descuento += 10;
        }else if(HotelC+viajeC >= 2){
            descuento += 5;
        }
        return this.repositorio.getDescuento() + descuento;
    }

    @Override
    public List<String> getLocalizadores() {
        return repositorio.getLocalizadores();
    }

    @Override
    public void addLocalizador(String localizador) {
        this.repositorio.getLocalizadores().add(localizador);
    }

    @Override
    public String toString() {
        return repositorio + " BoletoTransporte ";
    }
}

