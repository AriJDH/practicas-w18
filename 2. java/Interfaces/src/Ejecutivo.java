public class Ejecutivo implements Deposito,Transferencia{

    @Override
    public void depositar() {
        System.out.println("Ud. està realizando un deposito");
    }

    @Override
    public void tansaccionOk() {
        Deposito.super.tansaccionOk();
    }

    @Override
    public void transaccionNoOk() {
        Deposito.super.transaccionNoOk();
    }

    @Override
    public void transferir() {
        System.out.println("Ud. està realizando una transferencia");
    }
}
