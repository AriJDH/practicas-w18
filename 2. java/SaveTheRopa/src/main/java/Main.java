import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda campera = new Prenda("Levi", "Campera de cuero");
        Prenda camisaCuadros = new Prenda("Lacoste", "Camisa a cuadros");
        Prenda camperaCuero = new Prenda("Campo", "Campo de cuero");

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendasAGuardar = new ArrayList<Prenda>();
        List<Prenda> prendasAGuardar2 = new ArrayList<Prenda>();

        prendasAGuardar.add(campera);
        prendasAGuardar.add(camisaCuadros);
        prendasAGuardar2.add(camperaCuero);

        Integer numeroPrendas = guardaRopa.guardarPrendas(prendasAGuardar);
        Integer numeroPrenda2 = guardaRopa.guardarPrendas(prendasAGuardar2);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendas = guardaRopa.devolverPrendas(numeroPrendas);

        prendas.forEach(Prenda::imprimir);


    }
}
