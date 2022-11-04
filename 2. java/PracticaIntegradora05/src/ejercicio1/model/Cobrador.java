package ejercicio1.model;

import ejercicio1.interfaces.ConsultaDeSaldo;
import ejercicio1.interfaces.RetiroDeEfectivo;

public class Cobrador extends Cliente implements RetiroDeEfectivo, ConsultaDeSaldo {

    @Override
    public void hacerConsultaDeSaldo() {

        System.out.println("Consultado Saldo . . .");
        randomizador();
        System.out.println();

    }

    @Override
    public void hacerRetiroDeEfectivo(int montoRetiro) {

        System.out.println("Retirando la suma de: $" + montoRetiro);
        randomizador();
        System.out.println();

    }

}
