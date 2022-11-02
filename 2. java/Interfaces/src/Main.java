public class Main {
    public static void main(String[] args) {

        Cobrador clienteCobrador = new Cobrador();
        Ejecutivo clienteEjecutivo = new Ejecutivo();
        Basic clienteBasic = new Basic();

        clienteBasic.consultarSaldo();
        clienteBasic.tansaccionOk();
        clienteBasic.retirarEfectivo();
        clienteBasic.transaccionNoOk();


    }
}