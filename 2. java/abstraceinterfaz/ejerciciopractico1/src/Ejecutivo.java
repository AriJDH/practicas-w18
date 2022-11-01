public class Ejecutivo {

    private Deposito deposito;
    private Transferencia transferencia;
    private double monto;

    public double getMonto() {
        return monto;
    }
    public Ejecutivo(){}
    public Ejecutivo(double monto){
        this.monto = monto;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    public void hacerDeposito(){
        deposito = new Deposito();
        if(monto >=1)
            deposito.transaccionOK(monto);
        else
            deposito.transaccionNoOk(monto);
    }
    public void hacerTransferencia(){
        transferencia = new Transferencia();
        if(monto >=1)
            transferencia.transaccionOK(monto);
        else
            transferencia.transaccionNoOk(monto);
    }
}
