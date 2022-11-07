public class Main {

    public static void main(String[] args) {

        Integer resultado;

        Generador generador = new Generador();

        //Establezco un segundo valor

        System.out.println("El valor establecido es ");
        generador.establecerValor(2);
        System.out.println(generador.getValor());

        System.out.println("Los siguientes valores son: ");
        generador.valorSiguiente();
        System.out.println(generador.valorSiguiente());
        generador.valorSiguiente();
        System.out.println(generador.valorSiguiente());
        generador.valorSiguiente();
        System.out.println(generador.valorSiguiente());

        //Reinicio la serie

        generador.reiniciarSerie();

        //Establezco un segundo valor

        System.out.println("El valor establecido es: ");
        generador.establecerValor(3);
        System.out.println(generador.getValor());

        System.out.println("Los siguientes valores son: ");
        generador.valorSiguiente();
        System.out.println(generador.valorSiguiente());
        generador.valorSiguiente();
        System.out.println(generador.valorSiguiente());
        generador.valorSiguiente();
        System.out.println(generador.valorSiguiente());

    }
}
