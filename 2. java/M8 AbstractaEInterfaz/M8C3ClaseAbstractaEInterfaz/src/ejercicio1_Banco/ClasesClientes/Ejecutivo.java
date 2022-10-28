package ejercicio1_Banco.ClasesClientes;

import ejercicio1_Banco.Interfaz.Consultable;
import ejercicio1_Banco.Interfaz.Depositable;
import ejercicio1_Banco.Interfaz.Transferible;


public class Ejecutivo extends Cliente implements Depositable, Transferible, Consultable {


    public Ejecutivo(double saldo) {
        super(saldo);
    }


    @Override
    public void consultar() {
        System.out.println("[Cliente " + this + "] { CONSULTAR } Saldo $" + super.getSaldo());
    }

    @Override
    public void depositar(double monto) {
        if(ingresar(monto)){
            transaccionOk(this + "] { DEPOSITAR } $" + monto);
        } else {
            transaccionNoOk(toString());
            System.out.println("{ DEPOSITAR }");
        }
        consultar();
    }

    @Override
    public void transferir(double monto) {

        if(extraer(monto)){
            transaccionOk(this + "] { TRANSFERIR } $" + monto);
        } else {
            transaccionNoOk(this.toString());
            System.out.println("{ TRANSFERIR }");
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


    private boolean ingresar(double monto) {
        boolean ingreso = false;
        if(monto > 0) {
            setSaldo(super.getSaldo() + monto);
            ingreso = true;
        } else {
            transaccionNoOk(toString());
        }
        return ingreso;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
