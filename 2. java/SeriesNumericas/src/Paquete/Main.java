package Paquete;

public class Main {

    public static void main(String[] args) {
        //La serie de 3 que la hice con integer
        System.out.println("La serie de 3 que la hice con integer");
        SerieDeTres serieNueva=new SerieDeTres();

        serieNueva.valorInicial(4);
        System.out.println(serieNueva.valorSiguiente());
        System.out.println(serieNueva.valorSiguiente());
        serieNueva.reiniciarSerie();
        System.out.println(serieNueva.valorSiguiente());
        System.out.println(" ");

        //La serie de 2 que la hice con double
        System.out.println("La serie de 2 que la hice con double");
        SerieDeDos serieNueva2=new SerieDeDos();

        serieNueva2.valorInicial(4.0);
        System.out.println(serieNueva2.valorSiguiente());
        System.out.println(serieNueva2.valorSiguiente());
        serieNueva2.reiniciarSerie();
        System.out.println(serieNueva2.valorSiguiente());


    }
}
