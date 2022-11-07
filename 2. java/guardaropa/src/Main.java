import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("cheeky", "campera");
        Prenda prenda2 = new Prenda("nike", "remera");
        List<Prenda> prendas = Stream.of(prenda1, prenda2).collect(Collectors.toList());

        int id = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        System.out.println("------------------------------------");
        List<Prenda> prendasGuardadas = guardaRopa.devolverPrendas(id);

        prendasGuardadas.stream().forEach(System.out::println);
    }
}
