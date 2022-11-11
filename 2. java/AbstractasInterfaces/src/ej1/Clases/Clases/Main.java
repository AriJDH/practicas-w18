package ej1.Clases.Clases;

public class Main {
    public static void main(String[] args) {

        Ejecutivo ej = new Ejecutivo();
        Basic bas = new Basic();

        System.out.println(ej.depositarDinero(19000));
        System.out.println(ej.transferir(180000, "ab15848ss"));


        System.out.println(bas.consultaDeSaldo());
        System.out.println(bas.pagoDeServicios("Luz"));
        System.out.println(bas.retiroDeEfectivo(120000));



    }
}
