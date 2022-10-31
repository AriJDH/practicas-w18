package ClasesAbstractas_e_Interfaces;

import ClasesAbstractas_e_Interfaces.Clientes.Basic;
import ClasesAbstractas_e_Interfaces.Clientes.Cobrador;
import ClasesAbstractas_e_Interfaces.Clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic b = new Basic();
        Cobrador c = new Cobrador();
        Ejecutivo e = new Ejecutivo();

        b.consultaSaldo();
        b.pagoServicio();
        b.retiroEfectivo();
        c.consultaSaldo();
        c.retiroEfectivo();
        e.depositoEfectivo();
        e.transferenciaEfectivo();

    }
}
