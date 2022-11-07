package ejercicio_2;

public class Main {

    public static void main(String[] args) {
        Serie1 serie1 = new Serie1(0);
        Serie2 serie2 = new Serie2(0);

        System.out.println("--------------------------------");
        System.out.println("SERIE 3");
        System.out.println("--------------------------------\n");

        serie1.imprimir(serie1.devolverValor());
        serie1.imprimir(serie1.devolverValor());
        serie1.nuevoValorInicial(0);


    }

}
