package Clientes;

import Transacciones.ConsultaSaldoL;
import Transacciones.PagoServicios;
import Transacciones.RetiroEfectivo;

/*Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.*/
public class Basic implements ConsultaSaldoL, PagoServicios, RetiroEfectivo {

    @Override
    public void consultarSaldo(){
        System.out.println("Consultando saldo");
    }

    @Override
    public void pagarServicio(String tipoServicio){
        System.out.println("Servicio: " + tipoServicio + " Pagado");
    }

    @Override
    public void retirarEfectivo(double montoRetirado){
        System.out.println("Usted ha retirado:" + montoRetirado + "Pesos" );   /*En pesos*/
    }

    @Override
    public void transaccionOk(String tipoTransaccion){
        System.out.println(tipoTransaccion + "Finalizada correctamente");
    }
    @Override
    public void transaccionNoOk(String tipoTransaccion){
        System.out.println(tipoTransaccion + "No se pudo realizar correctamente");
    }



}

