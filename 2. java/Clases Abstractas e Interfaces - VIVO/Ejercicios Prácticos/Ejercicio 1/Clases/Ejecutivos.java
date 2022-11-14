public class Ejecutivos implements Depósito, Transferencia {

    @Override
    public void realizarDeposito(){
        System.out.println("Realizando deposito ... ");
    }

    @Override
    public void realizarTransferencia(){
        System.out.println("Realizando transferencia ... ");
    }

    @Override
    public void transaccionOk(){
        System.out.println("La transaccion se realizo correctamente.");
    }

    @Override
    public void transaccionNoOk(){
        System.out.println("La transaccion no ha podido realizarse.");
    }

}
