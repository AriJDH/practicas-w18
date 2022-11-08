import java.security.Guard;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Levis", "pantalón");
        Prenda prenda2 = new Prenda("Wanama", "remera");

        List<Prenda> prendaList = Arrays.asList(prenda1, prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendaList);
        guardaRopa.guardarPrendas(prendaList);
        guardaRopa.mostrarPrendas();
    }
}
