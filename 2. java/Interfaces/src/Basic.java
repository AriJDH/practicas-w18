public class Basic implements ConsultaSaldo,PagoServicio,RetiroEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("Ud. està consultando su saldo");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Ud. està pagando un servicio");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Ud. està retirando efectivo");
    }

    @Override
    public void tansaccionOk() {
        RetiroEfectivo.super.tansaccionOk();
    }

    @Override
    public void transaccionNoOk() {
        RetiroEfectivo.super.transaccionNoOk();
    }
}
