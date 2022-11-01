package user;

import service.Deposito;
import service.Transferencia;

public class Ejecutivo extends User{

    private final Deposito deposito;
    private final Transferencia transferencia;

    public Ejecutivo(Deposito deposito, Transferencia transferencia) {
        this.deposito = deposito;
        this.transferencia = transferencia;
    }

    public Deposito getDeposito() {
        deposito.setUser(this);
        return deposito;
    }

    public Transferencia getTransferencia() {
        transferencia.setUser(this);
        return transferencia;
    }

}
