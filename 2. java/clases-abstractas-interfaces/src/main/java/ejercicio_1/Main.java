package ejercicio_1;

import ejercicio_1.service.ConsultaSaldo;
import ejercicio_1.service.Deposito;
import ejercicio_1.service.PagoServicio;
import ejercicio_1.service.RetiroEfectivo;
import ejercicio_1.service.Transferencia;
import ejercicio_1.user.Basic;
import ejercicio_1.user.Cobrador;
import ejercicio_1.user.Ejecutivo;

public class Main {

    public static void main(String[] args) {

        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        Deposito deposito = new Deposito();
        PagoServicio pagoServicio = new PagoServicio();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        Transferencia transferencia = new Transferencia();

        Ejecutivo daniel = new Ejecutivo(deposito, transferencia);
        Basic alberto = new Basic(consultaSaldo, pagoServicio, retiroEfectivo);
        Basic rogelio = new Basic(consultaSaldo, pagoServicio, retiroEfectivo);
        Cobrador matias = new Cobrador(retiroEfectivo, consultaSaldo);

        daniel.setNombre("Daniel");
        daniel.getDeposito().depositar(500, false, daniel);
        daniel.getDeposito().depositar(500, true, daniel);
        daniel.imprimirDatosDeCuenta();

        alberto.setNombre("Alberto");
        alberto.setSaldo(1000);
        alberto.getPagoServicio().pagarServicio("Electricidad", 1000.0);
        alberto.imprimirDatosDeCuenta();

        daniel.getDeposito().depositar(500, false, alberto);

        alberto.getConsultaSaldo().mostrarSaldo(false);


        rogelio.setNombre("Rogelio");
        rogelio.setSaldo(5000);
        rogelio.getPagoServicio().pagarServicio("Gas", 3000);
        rogelio.imprimirDatosDeCuenta();

    }
}
