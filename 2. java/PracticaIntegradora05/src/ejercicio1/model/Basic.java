package ejercicio1.model;

import ejercicio1.interfaces.ConsultaDeSaldo;
import ejercicio1.interfaces.PagoDeServicios;
import ejercicio1.interfaces.RetiroDeEfectivo;

public class Basic extends Cliente implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

    @Override
    public void hacerConsultaDeSaldo() {

        System.out.println("Consultando Saldo . . .");
        randomizador();
        System.out.println();

    }

    @Override
    public void hacerPagoDeServicios(String nombreServicio) {

        System.out.println("Realizando Pago del servicio: " + nombreServicio);
        randomizador();
        System.out.println();
    }

    @Override
    public void hacerRetiroDeEfectivo(int montoRetiro) {

        System.out.println("Realizando Retiro de: $" + montoRetiro);
        randomizador();
        System.out.println();
    }

}
