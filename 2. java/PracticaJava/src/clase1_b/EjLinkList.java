package clase1_b;

import java.util.LinkedList;

public class EjLinkList {
    public static void imprimir(LinkedList<String>lista){
        for(String elemento:lista)
            System.out.println(elemento);


    }

    public static void main(String[] args) {
        LinkedList<String> lista1 = new LinkedList<String>();
        lista1.add("Independiente");
        lista1.add("Nacional");
        lista1.add("Patronato");
        lista1.add("River");
        lista1.add("Atl Nacional");
    }

}
