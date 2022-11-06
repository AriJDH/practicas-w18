import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda=new Prenda("Nike","T-shit");
        Prenda prenda1=new Prenda("Adidas","shit");
        List<Prenda>prendas=new ArrayList<>();
        prendas.add(prenda);
        prendas.add(prenda1);
        GuardaRopa guardaRopa=new GuardaRopa();
        guardaRopa.guardarPrenda(prendas);
        guardaRopa.mostrarPrenda();

    }
}
