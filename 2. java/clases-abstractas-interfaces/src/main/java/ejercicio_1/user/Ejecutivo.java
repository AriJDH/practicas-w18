package ejercicio_1.user;

import ejercicio_1.service.Deposito;
import ejercicio_1.service.Transferencia;

public class Ejecutivo extends User {

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
