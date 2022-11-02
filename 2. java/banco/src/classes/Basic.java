package classes;

import interfaces.ConsultaDeSaldo;
import interfaces.PagoDeServicio;
import interfaces.RetiroDeEfectivo;

public class Basic implements ConsultaDeSaldo, PagoDeServicio, RetiroDeEfectivo {
    @Override
    public void realizarConsulta() {
        boolean consulta = true;

        if(consulta){
            transactionOk("consulta");
        }else{
            transactionNoOk("consulta");
        }
    }

    @Override
    public void realizarPago(double importe) {
        boolean pago = false;

        if(pago){
            transactionOk("pago por un importe de $" + importe + ", ");
        }else{
            transactionNoOk("pago por un importe de $" + importe + ", ");
        }
    }

    @Override
    public void realizarRetiro(double importe) {
        boolean retiro = true;

        if(retiro){
            transactionOk("retiro por un importe de $" + importe + ", ");
        }else{
            transactionNoOk("retiro por un importe de $" + importe + ", ");
        }

    }

    @Override
    public void transactionOk(String tipo) {
        System.out.println("La transacción " + tipo + " se ha realizado con éxito.");
    }

    @Override
    public void transactionNoOk(String tipo) {
        System.out.println("La transacción " + tipo + " no se ha podido realizar con éxito. Intente nuevamente por favor.");
    }
}
