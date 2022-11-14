public class main {
    public static void main(String[] args){

        //Casos de prueba
        Ejecutivos e = new Ejecutivos();
        e.realizarDeposito();
        e.realizarTransferencia();
        e.transaccionOk();
        e.transaccionNoOk();

        Basic b = new Basic();
        b.realizarConsultaDeSaldo();
        b.realizarPagoDeServicios();
        b.realizarRetiroDeEfectivo();
        b.transaccionOk();
        b.transaccionNoOk();

        Cobradores c = new Cobradores();
        c.realizarConsultaDeSaldo();
        c.realizarRetiroDeEfectivo();
        c.transaccionOk();
        c.transaccionNoOk();



    }

}
