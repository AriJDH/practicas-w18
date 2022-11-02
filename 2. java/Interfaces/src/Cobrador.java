public class Cobrador implements RetiroEfectivo, ConsultaSaldo{

    @Override
    public void consultarSaldo() {
        System.out.println("Ud. està consultado su saldo");
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
