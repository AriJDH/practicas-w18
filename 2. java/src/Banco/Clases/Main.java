package Banco.Clases;

public class Main {
    public static void main(String[] args) {
        Ejecutivos ejecutivos = new Ejecutivos();
        ejecutivos.hacerDeposito(1500000);

        Basic basic = new Basic();
        basic.consultaDeSaldo();

        Cobradores cobradores = new Cobradores();
        cobradores.retiroDeEfectivo(8000000);
    }
}
