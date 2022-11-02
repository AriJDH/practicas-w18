package ejercicio1_Banco.Model;

import ejercicio1_Banco.Interfaz.Consultable;
import ejercicio1_Banco.Interfaz.Pagable;
import ejercicio1_Banco.Interfaz.Retirable;

public class Basic extends Cliente implements Pagable, Retirable, Consultable {

    public Basic(double saldo) {
        super(saldo);
    }

    @Override
    public void consultar() {
        System.out.println("[Cliente " + this + "] { CONSULTAR } Saldo $" + super.getSaldo());
    }

    @Override
    public void pagar(double monto) {
        if(extraer(monto)){
            transaccionOk(this + "] { PAGAR } $" + monto);
            consultar();
        } else {
            System.out.println("{ PAGAR }");
        }
        consultar();
    }


    @Override
    public void retirar(double monto) {
        if(extraer(monto)){
            transaccionOk(this + "] { RETIRAR } $" + monto);
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
