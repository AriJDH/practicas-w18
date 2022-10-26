package practica_clase_vivo_26_10_22;

import java.util.ArrayList;

public class ListaEjemplo {

    public static void main(String[] args) {
        ArrayList<String> pruebalista = new ArrayList<>();
        pruebalista.add("Hola");

        for (String valor : pruebalista) {
            System.out.println(valor);
        }

        String valor = pruebalista.remove(0);

        System.out.println("valor eliminado" + valor);
    }
}
