import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            /*- Crear en la clase Main un escenario en el cual alguien guarde dos prendas,
                reciba el código y luego consulta por sus prendas guardadas.*/

        Prenda prenda = new Prenda(1, "Kosiuko","remera");
        Prenda prenda1 = new Prenda(2, "Las Pepas", "pantalón");

        List<Prenda> lista1 = new ArrayList<>();
        lista1.add(prenda1);
        lista1.add(prenda);

        Guardaropa guardaropa = new Guardaropa(1, new HashMap<>());
        System.out.println("Guardaropas ID: "+guardaropa.guardarPrendas(lista1));

        System.out.println("Las prendas en tu Guardaropas son las siguientes: ");
        guardaropa.mostrarPrendas();




    }
}