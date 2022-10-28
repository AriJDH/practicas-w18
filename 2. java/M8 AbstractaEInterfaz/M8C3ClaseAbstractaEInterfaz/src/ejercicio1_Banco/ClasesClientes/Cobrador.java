package ejercicio1_Banco.ClasesClientes;

import ejercicio1_Banco.Interfaz.Consultable;
import ejercicio1_Banco.Interfaz.Retirable;

public class Cobrador extends Cliente implements Retirable, Consultable {


    public Cobrador(double saldo) {
        super(saldo);
    }

    @Override
    public void consultar() {
        System.out.println("[Cliente " + toString()  + "] { CONSULTAR } Saldo $" + super.getSaldo());
    }

    @Override
    public void retirar(double monto) {
        if(extraer(monto)){
            transaccionOk(toString() + "] { RETIRAR } $" + monto);
        } else {
            System.out.println("{ RETIRAR }");
        }
        consultar();
    }


    private boolean extraer(double monto) {
        //todo refactor para no repetir código
        boolean extrajo = false;
        if(super.getSaldo() >= (super.getSaldo() - monto) && (super.getSaldo() - monto) >= 0) {
            setSaldo(super.getSaldo() - monto);
            extrajo = true;
        } else {
            transaccionNoOk(toString());
        }
        return extrajo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
